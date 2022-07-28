package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.domain.Player;
import com.codeseek.footballmanager.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByTeam(Team team);
}
