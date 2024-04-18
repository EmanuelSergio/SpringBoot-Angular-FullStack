package io.github.emanuelSergio.clientes.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class ServicoPrestado {

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

    @Column
    private LocalDate data;

}
