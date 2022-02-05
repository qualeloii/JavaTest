package com.cd2tec.javaChallenge.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.cd2tec.javaChallenge.domain.model.Encomenda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private float vlTotalFrete;
    private String dataPrevistaEntrega;
    private String cepOrigem;
    private String cepDestino;

    public ResponseDTO (Encomenda encomenda) {
        this.vlTotalFrete = encomenda.getVlTotalFrete();
        this.dataPrevistaEntrega = encomenda.getDataPrevistaEntrega();
        this.cepOrigem = encomenda.getCepOrigem();
        this.cepDestino = encomenda.getCepDestino();
    }

    public static List<ResponseDTO> ResponseDTOList(List<Encomenda> encomendaList){
        return encomendaList.stream().map(ResponseDTO::new).collect(Collectors.toList());
    }
    
}
