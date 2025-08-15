package br.com.iniflex.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private final String nome;
    private final LocalDate dataNascimento;

    private static final DateTimeFormatter BR_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() { return nome; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getDataNascimentoFormatada() { return dataNascimento.format(BR_DATE); }
}
