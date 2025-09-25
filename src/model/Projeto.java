// package com.example.projetomanagement.model;

import java.time.LocalDate;

/*
 * Classe que representa um projeto no sistema.
 * Campos bem simples, com getters e setters.
 */

public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Status status;
    private int gerente;

    public enum Status {
        PLANEJADO, EM_PROGRESSO, FINALIZADO, CANCELADO
    }

    public Projeto() { }

    public Projeto(String nome, String descricao,
                   LocalDate dataInicio, LocalDate dataFim,
                   Status status, int gerente) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.gerente = gerente;
    }

    // getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public int getGerente() { return gerente; }
    public void setGerente(int gerente) { this.gerente = gerente; }

    // exibir detalhes do projeto
    @Override
    public String toString() {
        return "\nProjeto:" +
                id + " | " +
                nome + " | " +
                descricao + " | " +
                dataInicio + " | " +
                dataFim + " | " +
                status + " | " +
                gerente;
    }
}
