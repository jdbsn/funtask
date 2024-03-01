package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Crianca;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mang.funtask.dominio.modelos.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CriancaRepositorio extends JpaRepository<Crianca, UUID> {

    @Query("SELECT c FROM Crianca c WHERE c.responsavel.id = :idResponsavel")
    Optional<List<Crianca>> encontrarPorIdResponsavel(UUID idResponsavel);

}
