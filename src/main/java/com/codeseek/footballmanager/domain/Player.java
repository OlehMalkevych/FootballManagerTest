package com.codeseek.footballmanager.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private Long experience;

    private Long age;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

}
