package br.com.fiap.odontoprev.controller;

import br.com.fiap.odontoprev.model.Dentista;
import br.com.fiap.odontoprev.repository.DentistaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dentistas", produces = {"application/json"})
@Tag(name = "api-dentistas")
public class DentistaController {
    @Autowired
    DentistaRepository dentistaRepository;

    @GetMapping
    public ResponseEntity<List<Dentista>> readDentistas(){
        List<Dentista> listaDentistas = dentistaRepository.findAll();
        return new ResponseEntity<>(listaDentistas, HttpStatus.OK);
    }

}
