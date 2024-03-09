package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Atividade;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepositorio extends JpaRepository<Atividade, UUID> {

  List<Atividade> findAllByIdResponsavel(UUID idResponsavel);
}
