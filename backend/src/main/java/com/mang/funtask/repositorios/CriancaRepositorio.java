package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CriancaRepositorio extends JpaRepository<Crianca, UUID> {
}
