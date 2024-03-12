package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Transacao;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransacaoRepositorio extends JpaRepository<Transacao, UUID> {

  @Query("SELECT t FROM Transacao t WHERE t.crianca.id = :idCrianca")
  List<Transacao> findAllByIdCrianca(UUID idCrianca);

}
