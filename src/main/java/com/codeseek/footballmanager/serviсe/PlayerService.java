package com.codeseek.footballmanager.serviсe;

import com.codeseek.footballmanager.domain.Player;
import com.codeseek.footballmanager.dto.request.PlayerRequestDTO;

import java.io.IOException;
import java.util.List;

public interface PlayerService {

    void save(PlayerRequestDTO player) throws IOException;

    Player getById(Long id);

    List<Player> getAll();

    List<Player> getAllByTeamId(Long id);

    void delete(Long id);

    Long sumOfPlayerTransfer(Long id);

    Player update(PlayerRequestDTO player, Long id) throws IOException;

}
