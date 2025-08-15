package br.com.iniflex.repo;

import br.com.iniflex.domain.Funcionario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepositorioFuncionarioEmMemoria implements FuncionarioRepository {

    private final List<Funcionario> dados = new ArrayList<>(FuncionarioMockFactory.obterFuncionarios());

    @Override
    public List<Funcionario> findAll() {
        return dados;
    }

     @Override
    public void removeByName(String nome) {
        for (Iterator<Funcionario> it = dados.iterator(); it.hasNext();) {
            if (it.next().getNome().equalsIgnoreCase(nome)) {
                it.remove();
                break;
            }
        }
    }
}
