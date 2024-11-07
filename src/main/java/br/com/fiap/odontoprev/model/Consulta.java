package br.com.fiap.odontoprev.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "OP_CONSULTA")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_consulta")
    private Timestamp data;

    @ManyToOne
    @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "ID_DENTISTA", referencedColumnName = "id")
    private Dentista dentista;

    @ManyToOne
    @JoinColumn(name = "ID_UNIDADE", referencedColumnName = "id")
    private Unidade unidade;

    @Column(name = "MOTIVO_CONSULTA")
    private String motivo;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}
