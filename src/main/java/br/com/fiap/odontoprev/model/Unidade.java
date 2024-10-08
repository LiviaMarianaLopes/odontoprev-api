package br.com.fiap.odontoprev.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OP_UNIDADE")
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_UNIDADE")
    private String nome;

    @Column(name = "telefone")
    private int telefone;

    @OneToOne
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "id")
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}