package br.com.fiap.odontoprev.service;

import br.com.fiap.odontoprev.dto.ConsultaRequest;
import br.com.fiap.odontoprev.dto.ConsultaResponse;
import br.com.fiap.odontoprev.model.Consulta;
import br.com.fiap.odontoprev.model.Dentista;
import br.com.fiap.odontoprev.model.Paciente;
import br.com.fiap.odontoprev.model.Unidade;
import br.com.fiap.odontoprev.repository.DentistaRepository;
import br.com.fiap.odontoprev.repository.PacienteRepository;
import br.com.fiap.odontoprev.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ConsultaMapper {
    @Autowired
    private DentistaRepository dentistaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private UnidadeRepository unidadeRepository;
public Consulta requestToConsulta(ConsultaRequest consultaRequest){
    Paciente paciente = pacienteRepository.findById(consultaRequest.idPaciente())
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

    Dentista dentista = dentistaRepository.findById(consultaRequest.idDentista())
            .orElseThrow(() -> new RuntimeException("Dentista não encontrado"));

    Unidade unidade = unidadeRepository.findById(consultaRequest.idUnidade())
            .orElseThrow(() -> new RuntimeException("Unidade não encontrada"));

    Consulta consulta = new Consulta();
    consulta.setData(consultaRequest.data());
    consulta.setPaciente(paciente);
    consulta.setDentista(dentista);
    consulta.setUnidade(unidade);
    return consulta;
}
    public ConsultaResponse consultaToResponse(Consulta consulta) {
        return new ConsultaResponse(
                consulta.getId(),
                consulta.getData(),
                consulta.getPaciente(),
                consulta.getDentista(),
                consulta.getUnidade()
        );
    }
}
