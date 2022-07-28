package com.codeseek.footballmanager.controller;

import com.codeseek.footballmanager.dto.request.TeamRequestDTO;
import com.codeseek.footballmanager.dto.response.TeamResponseDTO;
import com.codeseek.footballmanager.serviсe.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    private void create(@RequestBody TeamRequestDTO teamRequestDTO) throws IOException {
        teamService.save(teamRequestDTO);
    }

    @PutMapping("/{id}")
    private TeamResponseDTO updateTeam(@RequestBody TeamRequestDTO teamRequestDTO, @PathVariable("id") Long id){
        return new TeamResponseDTO(teamService.update(teamRequestDTO, id));
    }

    @GetMapping("/{id}")
    private TeamResponseDTO getById(@PathVariable("id") Long id){
        return new TeamResponseDTO(teamService.getById(id));
    }

    @GetMapping
    private List<TeamResponseDTO> getAll(){
        return teamService.getAll()
                .stream()
                .map(TeamResponseDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id){
        teamService.delete(id);
    }
}
