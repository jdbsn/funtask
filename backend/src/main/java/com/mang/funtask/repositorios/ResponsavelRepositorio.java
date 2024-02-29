package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Responsavel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsavelRepositorio extends JpaRepository<Responsavel, UUID> {

}
