package com.codeseek.footballmanager.serviсe;

import com.codeseek.footballmanager.domain.Transfer;
import com.codeseek.footballmanager.dto.request.TransferRequestDTO;

import java.util.List;

public interface TransferService {
    void save(TransferRequestDTO transferRequestDTO);

    Transfer getById(Long id);

    List<Transfer> getAll();

    Transfer update(TransferRequestDTO transferRequestDTO, Long id);

    void delete(Long id);
}
