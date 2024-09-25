package br.com.fiap.odontoprev.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CIDADE")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "cod_estado", referencedColumnName = "id")
    private Estado estado;

    // Getters e Setters
}
