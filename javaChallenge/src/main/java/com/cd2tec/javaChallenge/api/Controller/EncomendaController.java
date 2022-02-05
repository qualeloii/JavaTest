package com.cd2tec.javaChallenge.api.Controller;

import java.util.List;

import javax.validation.Valid;

import com.cd2tec.javaChallenge.domain.dto.RequestDTO;
import com.cd2tec.javaChallenge.domain.dto.ResponseDTO;
import com.cd2tec.javaChallenge.domain.service.EncomendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encomendas")
public class EncomendaController {

    @Autowired
    EncomendaService encomendaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO adicionar(@Valid @RequestBody RequestDTO requestDTO){
        return encomendaService.calcularFrete(requestDTO);
    }

    @GetMapping
    public List<ResponseDTO> listar(){
        return encomendaService.listar();
    }

}
