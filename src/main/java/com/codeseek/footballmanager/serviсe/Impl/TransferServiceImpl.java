package com.codeseek.footballmanager.serviсe.Impl;

import com.codeseek.footballmanager.domain.Team;
import com.codeseek.footballmanager.domain.Transfer;
import com.codeseek.footballmanager.dto.request.TransferRequestDTO;
import com.codeseek.footballmanager.repository.TransferRepository;
import com.codeseek.footballmanager.serviсe.PlayerService;
import com.codeseek.footballmanager.serviсe.TeamService;
import com.codeseek.footballmanager.serviсe.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Override
    public void save(TransferRequestDTO transferRequestDTO) {
        transferRepository.save(mapTransferRequestToTransfer(transferRequestDTO, null));
    }

    @Override
    public Transfer getById(Long id) {
        return transferRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transfer with id " + id + "doesn't exist"));
    }

    @Override
    public List<Transfer> getAll() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer update(TransferRequestDTO transferRequestDTO, Long id) {
        return transferRepository.save(mapTransferRequestToTransfer(transferRequestDTO,getById(id)));
    }

    @Override
    public void delete(Long id) {
        transferRepository.deleteById(id);
    }

    //Need to finish
    private Transfer mapTransferRequestToTransfer(TransferRequestDTO transferRequestDTO, Transfer transfer){
        if (transfer == null){
            transfer = new Transfer();

            playerService.getById(transferRequestDTO.getPlayer_id()).setTeam(teamService.getByName(transferRequestDTO.getTeamNameTo()));
            transfer.setSum(playerService.sumOfPlayerTransfer(transferRequestDTO.getPlayer_id()));
            teamService.withdrawMoney(teamService.getByName(transferRequestDTO.getTeamNameFrom()).getId(), transferRequestDTO.getPlayer_id());
            teamService.addMoney(teamService.getByName(transferRequestDTO.getTeamNameFrom()).getId(), transferRequestDTO.getPlayer_id());

            transfer.setTeams(teamService.getByName(transferRequestDTO.getTeamNameFrom()), teamService.getByName(transferRequestDTO.getTeamNameTo()));
        }

        transfer.setPlayer_id(transferRequestDTO.getPlayer_id());
        transfer.setTeamNameFrom(transferRequestDTO.getTeamNameFrom());
        transfer.setTeamNameTo(transferRequestDTO.getTeamNameTo());

        return transfer;
    }
}
