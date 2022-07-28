package com.codeseek.footballmanager.dto.request;

import lombok.*;

@Setter
@Getter
public class TransferRequestDTO {

    private String teamNameFrom;

    private String teamNameTo;

    private Long player_id;
}
