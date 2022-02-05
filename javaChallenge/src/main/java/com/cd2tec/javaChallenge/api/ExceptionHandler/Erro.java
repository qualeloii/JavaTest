package com.cd2tec.javaChallenge.api.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Erro {

    private Integer codeStatus;
    private LocalDateTime localDateTime;
    private List<details> detalhes;

    @AllArgsConstructor
    @Getter
    public static class details{
        private String nome;
        private String descricao;
    }
    
}
