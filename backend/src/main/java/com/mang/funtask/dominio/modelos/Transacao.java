package com.mang.funtask.dominio.modelos;

import com.mang.funtask.dominio.enums.TipoTransacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_transacao")
  private UUID id;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_transacao", nullable = false)
  private TipoTransacao tipoTransacao;

  @OneToOne
  @JoinColumn(name = "id_atividade", nullable = false)
  private Atividade atividade;
}
