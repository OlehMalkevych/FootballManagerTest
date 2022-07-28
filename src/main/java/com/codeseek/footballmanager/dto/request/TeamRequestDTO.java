package com.codeseek.footballmanager.dto.request;

import lombok.*;

@Setter
@Getter
public class TeamRequestDTO {

    private String name;

    private Long account;

    private Integer commission;
}
