package com.codeseek.footballmanager.dto.response;

import com.codeseek.footballmanager.domain.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerResponseDTO {

    private Long id;

    private String name;

    private String surname;

    private Long experience;

    private Long age;

    public PlayerResponseDTO(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.surname = player.getSurname();
        this.experience = player.getExperience();
        this.age = player.getAge();
    }
}
