package com.cd2tec.javaChallenge.api.Controller;

import com.cd2tec.javaChallenge.domain.model.Cep;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class cepController {

    public Cep get(String str){
        String url = "https://viacep.com.br/ws/" + str + "/json/";
        RestTemplate restTemplate = new RestTemplate();
        Cep result = restTemplate.getForObject(url, Cep.class);
        return result;
    }
    
}
