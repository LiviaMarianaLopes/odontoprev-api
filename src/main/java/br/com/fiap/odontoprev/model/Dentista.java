package br.com.fiap.odontoprev.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "OP_DENTISTA")
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_DENTISTA")
    private String nome;

    @Column(name = "cro")
    private String cro;

    @Column(name = "data_de_nascimento")
    private Date dataNascimento;
    @Column(name = "EMAIL_DENTISTA")
    private String email;
    @Column(name = "CPF_DENTISTA")
    private Long cpf;
    @OneToOne
    @JoinColumn(name = "id_genero", referencedColumnName = "id")
    private Genero genero;

    @Column(name = "telefone_dentista")
    private Long telefone;

    @OneToOne
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "id_login", referencedColumnName = "id")
    private Login login;
    @Column(name = "DENTISTA_SUSPEITO")
    private String suspeito;

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

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getSuspeito() {
        return suspeito;
    }

    public void setSuspeito(String suspeito) {
        this.suspeito = suspeito;
    }
}
