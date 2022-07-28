package com.codeseek.footballmanager.controller;

import com.codeseek.footballmanager.dto.request.TransferRequestDTO;
import com.codeseek.footballmanager.dto.response.TransferResponseDTO;
import com.codeseek.footballmanager.serviсe.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transfers")
@CrossOrigin
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    private void create(@RequestBody TransferRequestDTO transferRequestDTO){
        transferService.save(transferRequestDTO);
    }
    @PutMapping("/{id}")
    private TransferResponseDTO update(TransferRequestDTO transferRequestDTO, @PathVariable("id") Long id){
        return new TransferResponseDTO(transferService.update(transferRequestDTO,id));
    }

    @GetMapping("/{id}")
    private TransferResponseDTO getById(@PathVariable("id") Long id){
        return new TransferResponseDTO(transferService.getById(id));
    }

    @GetMapping
    private List<TransferResponseDTO> getAll(){
        return transferService.getAll()
                .stream()
                .map(TransferResponseDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id){
        transferService.delete(id);
    }
}
