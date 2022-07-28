package com.codeseek.footballmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long account;

    private Integer commission;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    List<Player> players;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Transfer> transfers = new HashSet<>();
}
