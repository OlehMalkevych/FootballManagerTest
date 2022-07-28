package com.codeseek.footballmanager.dto.response;

import com.codeseek.footballmanager.domain.Transfer;
import lombok.*;

@Getter
@Setter
public class TransferResponseDTO {

    private Long id;

    private Long sum;

    private String teamNameFrom;

    private String teamNameTo;

    private Long player_id;

    public TransferResponseDTO(Transfer transfer) {
        this.id = transfer.getId();
        this.sum = transfer.getSum();
        this.teamNameFrom = transfer.getTeamNameFrom();
        this.teamNameTo = transfer.getTeamNameTo();
        this.player_id = transfer.getPlayer_id();
    }
}
