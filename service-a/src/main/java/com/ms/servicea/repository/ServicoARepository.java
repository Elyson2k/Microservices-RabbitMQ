package com.ms.servicea.repository;

import com.ms.servicea.model.ServicoA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoARepository extends JpaRepository<ServicoA, Long> {
}
