package br.com.fiap.odontoprev.controller;

import br.com.fiap.odontoprev.dto.ConsultaRequest;
import br.com.fiap.odontoprev.dto.ConsultaResponse;
import br.com.fiap.odontoprev.model.Consulta;
import br.com.fiap.odontoprev.repository.ConsultaRepository;
import br.com.fiap.odontoprev.service.ConsultaMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/consultas", produces = {"application/json"})
@Tag(name = "api-consultas")
public class ConsultaController {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ConsultaMapper consultaMapper;
    @Operation(summary = "Cria uma consulta e grava no banco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Consulta cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping
    public ResponseEntity<ConsultaResponse> createConsulta(@Valid @RequestBody ConsultaRequest consultaRequest) {
        Consulta consultaConvertida = consultaMapper.requestToConsulta(consultaRequest);
        Consulta consulta = consultaRepository.save(consultaConvertida);
        if (consulta.getId() != null) {
            ConsultaResponse consultaResponse = consultaMapper.consultaToResponse(consulta);
            return new ResponseEntity<>(consultaResponse, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @Operation(summary = "Retorna todas as consultas cadastradas no banco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Nenhuma consulta encontrada",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<EntityModel<ConsultaResponse>>> readConsultas() {
        List<Consulta> listaConsultas = consultaRepository.findAll();
        if (listaConsultas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<EntityModel<ConsultaResponse>> listaConsultasResponse = new ArrayList<>();
        for (Consulta consulta : listaConsultas) {
            ConsultaResponse consultaResponse = consultaMapper.consultaToResponse(consulta);
            EntityModel<ConsultaResponse> consultaModel = EntityModel.of(consultaResponse,
                    linkTo(methodOn(ConsultaController.class)
                            .readConsulta(consulta.getId())).withSelfRel(),
                    linkTo(methodOn(ConsultaController.class)
                            .delete(consulta.getId())).withRel("Deletar consulta"),
                    linkTo(methodOn(ConsultaController.class)
                            .update(consulta.getId(), null)).withRel("Atualizar consulta"),
                    linkTo(methodOn(ConsultaController.class)
                            .readConsultas()).withRel("Lista de consultas")
            );
            listaConsultasResponse.add(consultaModel);
        }
        return new ResponseEntity<>(listaConsultasResponse, HttpStatus.OK);
    }
    @Operation(summary = "Retorna uma consulta dado o seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Nenhuma consulta encontrada",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ConsultaResponse>> readConsulta(@PathVariable Long id) {
        Optional<Consulta> consultaSalva = consultaRepository.findById(id);
        if (consultaSalva.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ConsultaResponse consultaResponse = consultaMapper.consultaToResponse(consultaSalva.get());
        EntityModel<ConsultaResponse> consultaModel = EntityModel.of(consultaResponse,
                linkTo(methodOn(ConsultaController.class)
                        .readConsulta(id)).withSelfRel(),
                linkTo(methodOn(ConsultaController.class)
                        .delete(id)).withRel("Deletar consulta"),
                linkTo(methodOn(ConsultaController.class)
                        .update(id, null)).withRel("Atualizar consulta"),
                linkTo(methodOn(ConsultaController.class)
                        .readConsultas()).withRel("Lista de consultas")
        );
        return new ResponseEntity<>(consultaModel, HttpStatus.OK);
    }

    @Operation(summary = "Atualiza uma consulta já existente no banco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Consulta não encontrada ou atributos informados são inválidos",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> update(@PathVariable Long id, @Valid @RequestBody ConsultaRequest consultaRequest) {
        Optional<Consulta> consultaSalva = consultaRepository.findById(id);
        if (consultaSalva.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Consulta consulta = consultaMapper.requestToConsulta(consultaRequest);
        consulta.setId(id);
        Consulta consultaAtualizada = consultaRepository.save(consulta);
        ConsultaResponse consultaResponse = consultaMapper.consultaToResponse(consultaAtualizada);
        return new ResponseEntity<>(consultaResponse, HttpStatus.OK);
    }

    @Operation(summary = "Exclui uma consulta do banco de dados dado um ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Consulta não encontrada",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "200", description = "Exclusão realizada com sucesso")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Consulta> consultaSalva = consultaRepository.findById(id);
        if (consultaSalva.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        consultaRepository.delete(consultaSalva.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}