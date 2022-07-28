package com.codeseek.footballmanager.domain;

import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sum;

    private String teamNameFrom;

    private String teamNameTo;

    private Long player_id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "teams_transfer",
            joinColumns = @JoinColumn(name = "transfer_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Team> teams = new HashSet<>();

    public void setTeams(Team from, Team to) {
        teams.add(from);
        teams.add(to);
    }
}
