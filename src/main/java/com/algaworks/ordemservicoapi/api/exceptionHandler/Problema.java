package com.algaworks.ordemservicoapi.api.exceptionHandler;

import java.time.LocalDateTime;

public class Problema {
    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(LocalDateTime tempo) {
        this.dataHora = tempo;
    }

    public String getString() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}