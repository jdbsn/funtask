package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Transacao;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepositorio extends JpaRepository<Transacao, UUID> {

}
