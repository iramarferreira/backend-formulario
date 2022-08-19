package com.grupo2.gestaoProjeto.BackFormulario.repository;

import com.grupo2.gestaoProjeto.BackFormulario.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, UUID> {
}
