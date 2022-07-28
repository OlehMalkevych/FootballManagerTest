package com.codeseek.footballmanager.serviсe;

import com.codeseek.footballmanager.domain.Team;
import com.codeseek.footballmanager.dto.request.TeamRequestDTO;

import java.io.IOException;
import java.util.List;

public interface TeamService {

    void save(TeamRequestDTO teamRequestDTO) throws IOException;

    Team getByName(String name);

    void withdrawMoney(Long teamId,Long playerId);

    void addMoney(Long teamId, Long sum);

    Team getById(Long id);

    List<Team> getAll();

    Team update(TeamRequestDTO teamRequestDTO, Long id);

    void delete(Long id);
}
