package br.com.fiap.odontoprev.controller;

import br.com.fiap.odontoprev.model.Unidade;
import br.com.fiap.odontoprev.repository.UnidadeRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/unidades", produces = {"application/json"})
@Tag(name = "api-unidades")
public class UnidadeController {
    @Autowired
    UnidadeRepository unidadeRepository;

    @GetMapping
    public ResponseEntity<List<Unidade>> readUnidades(){
        List<Unidade> listaUnidades = unidadeRepository.findAll();
        return new ResponseEntity<>(listaUnidades, HttpStatus.OK);
    }

}
