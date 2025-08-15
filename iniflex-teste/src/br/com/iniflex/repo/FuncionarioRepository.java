package br.com.iniflex.repo;

import br.com.iniflex.domain.Funcionario;

import java.util.List;

public interface FuncionarioRepository {
    List<Funcionario> findAll();
    void removeByName(String nome);
}