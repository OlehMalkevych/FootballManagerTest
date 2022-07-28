package com.codeseek.footballmanager.dto.request;

import lombok.*;

@Setter
@Getter
public class PlayerRequestDTO {

    private String name;

    private String surname;

    private Long experience;

    private Long age;

    private Long TeamId;
}
