package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team getByName(String Name);
}
