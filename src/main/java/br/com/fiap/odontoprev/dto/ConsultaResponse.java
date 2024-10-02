package br.com.fiap.odontoprev.dto;

import br.com.fiap.odontoprev.model.Dentista;
import br.com.fiap.odontoprev.model.Paciente;
import br.com.fiap.odontoprev.model.Unidade;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public record ConsultaResponse(
        long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
        Timestamp data,
        Paciente paciente,
        Dentista dentista,
        Unidade unidade
) {
}
