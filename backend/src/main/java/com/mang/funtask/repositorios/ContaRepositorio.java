package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Conta;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepositorio extends JpaRepository<Conta, UUID> {

}
