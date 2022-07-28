package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
