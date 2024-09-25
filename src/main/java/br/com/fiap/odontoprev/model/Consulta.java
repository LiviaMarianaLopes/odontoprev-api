package br.com.fiap.odontoprev.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "TB_CONSULTA")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "motivo_consulta")
    private Timestamp data;
    @Column(name = "data_consulta")
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "paciente_consulta", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "dentista_consulta", referencedColumnName = "id")
    private Dentista dentista;

    @ManyToOne
    @JoinColumn(name = "unidade_consulta", referencedColumnName = "id")
    private Unidade unidade;

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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
