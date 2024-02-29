package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Crianca;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriancaRepositorio extends JpaRepository<Crianca, UUID> {

}
