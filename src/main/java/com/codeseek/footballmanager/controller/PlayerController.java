package com.codeseek.footballmanager.controller;


import com.codeseek.footballmanager.dto.request.PlayerRequestDTO;
import com.codeseek.footballmanager.dto.response.PlayerResponseDTO;
import com.codeseek.footballmanager.serviсe.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping()
    private void createPlayer(@RequestBody PlayerRequestDTO playerRequestDTO) throws IOException{
        playerService.save(playerRequestDTO);
    }

    @PutMapping("/{id}")
    private PlayerResponseDTO updatePlayer(@RequestBody PlayerRequestDTO playerRequestDTO, @PathVariable("id") Long id) throws IOException{
       return new PlayerResponseDTO(playerService.update(playerRequestDTO, id));
    }

    @GetMapping("/teams/{id}")
    private List<PlayerResponseDTO> getAllByTeamId(@PathVariable("id") Long id){
        return playerService.getAllByTeamId(id)
                .stream()
                .map(PlayerResponseDTO::new)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    private PlayerResponseDTO getById(@PathVariable("id") Long id){
        return new PlayerResponseDTO(playerService.getById(id));
    }

    @GetMapping
    private List<PlayerResponseDTO> getAll(){
        return playerService.getAll()
                .stream()
                .map(PlayerResponseDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id){
        playerService.delete(id);
    }

}
