package com.cd2tec.javaChallenge.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.cd2tec.javaChallenge.domain.model.Encomenda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    @NotBlank
    @Size(max = 8)
    @Pattern(regexp = "^[0-9]*$", message = "CEP contém caracteres especiais, utilize somente numeros.")
    private String cepOrigem;

    @NotBlank
    @Size(max = 8)
    @Pattern(regexp = "^[0-9]*$", message = "CEP contém caracteres especiais, utilize somente numeros.")
    private String cepDestino;

    @NotBlank
    @Size(max = 60)
    private String nomeDestinatario;

    @Positive
    private float peso;


    public Encomenda parseEncomenda() {
        Encomenda encomenda = new Encomenda();
        encomenda.setCepOrigem(this.getCepOrigem());
        encomenda.setCepDestino(this.cepDestino);
        encomenda.setNomeDestinatario(this.nomeDestinatario);
        encomenda.setPeso(this.peso);
        return encomenda;   
    }
    
}
