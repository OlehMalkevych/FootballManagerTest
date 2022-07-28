package com.codeseek.footballmanager.serviсe.Impl;

import com.codeseek.footballmanager.domain.Team;
import com.codeseek.footballmanager.dto.request.TeamRequestDTO;
import com.codeseek.footballmanager.repository.TeamRepository;
import com.codeseek.footballmanager.serviсe.PlayerService;
import com.codeseek.footballmanager.serviсe.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerService playerService;


    @Override
    public void save(TeamRequestDTO teamRequestDTO){
        teamRepository.save(mapRequestTeamToTeam(teamRequestDTO, null));
    }

    @Override
    public Team getById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Team with id " + id + "doesn't exist"));
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team update(TeamRequestDTO teamRequestDTO, Long id) {
        return teamRepository.save(mapRequestTeamToTeam(teamRequestDTO, getById(id)));
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team getByName(String name) {
        return teamRepository.getByName(name);
    }

    @Override
    public void withdrawMoney(Long teamId,Long playerId) {
        teamRepository.findById(teamId)
                .get()
                .setAccount(teamRepository
                        .findById(teamId)
                        .get()
                        .getAccount() - (
                                playerService.sumOfPlayerTransfer(playerId) +
                                        playerService.sumOfPlayerTransfer(playerId) * (teamRepository.findById(teamId).get().getCommission() / 100)));
    }

    @Override
    public void addMoney(Long teamId, Long playerId) {
        teamRepository.findById(teamId)
                .get()
                .setAccount(teamRepository.findById(teamId)
                        .get()
                        .getAccount()
                        + playerService.sumOfPlayerTransfer(playerId)
                        + playerService.sumOfPlayerTransfer(playerId)
                        * (teamRepository.findById(teamId).get().getCommission() / 100));
    }

    private Team mapRequestTeamToTeam(TeamRequestDTO teamRequestDTO, Team team){
        if (team == null){
            team = new Team();
        }
        team.setName(teamRequestDTO.getName());
        team.setAccount(teamRequestDTO.getAccount());
        team.setCommission(teamRequestDTO.getCommission());
        return team;
    }
}
