package com.codeseek.footballmanager.dto.response;

import com.codeseek.footballmanager.domain.Team;
import lombok.*;

@Getter
@Setter
public class TeamResponseDTO {

    private Long id;

    private String name;

    private Long account;

    private Integer commission;

    public TeamResponseDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.account = team.getAccount();
        this.commission = team.getCommission();
    }
}
