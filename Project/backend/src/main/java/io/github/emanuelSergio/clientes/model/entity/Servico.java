package io.github.emanuelSergio.clientes.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")//chave estrangeira
    private Cliente cliente;

    @Column
    private BigDecimal valor;


}
