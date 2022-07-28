package com.codeseek.footballmanager.serviсe.Impl;

import com.codeseek.footballmanager.domain.Player;
import com.codeseek.footballmanager.dto.request.PlayerRequestDTO;
import com.codeseek.footballmanager.repository.PlayerRepository;
import com.codeseek.footballmanager.serviсe.PlayerService;
import com.codeseek.footballmanager.serviсe.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamService teamService;

    @Override
    public void save(PlayerRequestDTO playerRequestDTO) throws IOException {
        playerRepository.save(mapPlayerRequestToPlayer(playerRequestDTO, null));
    }

    @Override
    public Player getById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player with id " + id + "doesn't exist"));
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getAllByTeamId(Long id) {
        return playerRepository.findAllByTeam(teamService.getById(id));
    }

    @Override
    public Player update(PlayerRequestDTO player, Long id) throws IOException {
        return playerRepository.save(mapPlayerRequestToPlayer(player, getById(id)));
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Long sumOfPlayerTransfer(Long id) {
        return getById(id).getExperience() * 100000 / getById(id).getAge();
    }

    private Player mapPlayerRequestToPlayer(PlayerRequestDTO playerRequestDTO, Player player){
        if (player == null){
            player = new Player();
        }
        player.setName(playerRequestDTO.getName());
        player.setSurname(playerRequestDTO.getSurname());
        player.setAge(playerRequestDTO.getAge());
        player.setExperience(playerRequestDTO.getExperience());
        player.setTeam(teamService.getById(playerRequestDTO.getTeamId()));

        return player;
    }

}
