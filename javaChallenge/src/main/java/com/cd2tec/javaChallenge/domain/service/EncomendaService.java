package com.cd2tec.javaChallenge.domain.service;

import com.cd2tec.javaChallenge.domain.repository.EncomendaRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.cd2tec.javaChallenge.api.Controller.cepController;
import com.cd2tec.javaChallenge.domain.dto.RequestDTO;
import com.cd2tec.javaChallenge.domain.dto.ResponseDTO;
import com.cd2tec.javaChallenge.domain.model.Cep;
import com.cd2tec.javaChallenge.domain.model.Encomenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncomendaService {

    //private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    EncomendaRepository encomendaRepository;

    @Autowired
    cepController cepController;

    public List<ResponseDTO> listar(){
        List<Encomenda> encomendaList = encomendaRepository.findAll();
        return ResponseDTO.ResponseDTOList(encomendaList);
    }

    public Encomenda salvar(Encomenda encomenda){
        return encomendaRepository.save(encomenda);
    }

    public ResponseDTO calcularFrete(RequestDTO requestDTO){
        Encomenda encomenda = requestDTO.parseEncomenda();
        ResponseDTO responseDTO;

        float vlTotalFrete,valor = 1.0f;
        Integer diaParaEntrega;

        Calendar dataPrevistaEntrega = Calendar.getInstance();

        Cep cepOrigem = cepController.get(encomenda.getCepOrigem());
        Cep cepDestino = cepController.get(encomenda.getCepDestino());
        
        if (cepOrigem.getDdd().equals(cepDestino.getDdd())){
            vlTotalFrete = ((valor * encomenda.getPeso()) * 0.5f) ;
            diaParaEntrega = 1;
            dataPrevistaEntrega.add(Calendar.DAY_OF_MONTH, diaParaEntrega);
            encomenda.setDataPrevistaEntrega(dateFormat.format(dataPrevistaEntrega.getTime()));
            encomenda.setVlTotalFrete(vlTotalFrete);
        }
        else if (cepOrigem.getUf().equals(cepDestino.getUf())){
            vlTotalFrete = ((valor * encomenda.getPeso()) * 0.25f) ;
            diaParaEntrega = 3;
            dataPrevistaEntrega.add(Calendar.DAY_OF_MONTH, diaParaEntrega);
            encomenda.setDataPrevistaEntrega(dateFormat.format(dataPrevistaEntrega.getTime()));
            encomenda.setVlTotalFrete(vlTotalFrete);
        }else{
            vlTotalFrete = (valor * encomenda.getPeso()) ;
            diaParaEntrega = 10;
            dataPrevistaEntrega.add(Calendar.DAY_OF_MONTH, diaParaEntrega);
            encomenda.setDataPrevistaEntrega(dateFormat.format(dataPrevistaEntrega.getTime()));
            encomenda.setVlTotalFrete(vlTotalFrete);
        }
        responseDTO = new ResponseDTO(salvar(encomenda));
        return responseDTO;    
    }
}
