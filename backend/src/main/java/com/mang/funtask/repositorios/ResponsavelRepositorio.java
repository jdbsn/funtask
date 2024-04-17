package com.mang.funtask.repositorios;

import com.mang.funtask.dominio.modelos.Responsavel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResponsavelRepositorio extends JpaRepository<Responsavel, UUID> {

  Optional<Responsavel> findByEmail(String email);

  @Query("SELECT r.id FROM Responsavel r WHERE r.email = :email")
  UUID findIDByEmail(String email);

}
