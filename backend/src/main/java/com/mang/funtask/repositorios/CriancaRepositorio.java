package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Crianca;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CriancaRepositorio extends JpaRepository<Crianca, UUID> {

  @Query("SELECT c FROM Crianca c WHERE c.idResponsavel = :idResponsavel")
  Optional<List<Crianca>> encontrarPorIdResponsavel(UUID idResponsavel);

}
