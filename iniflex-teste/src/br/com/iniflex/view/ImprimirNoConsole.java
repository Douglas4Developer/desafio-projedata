package br.com.iniflex.view;

import br.com.iniflex.domain.Funcionario;
import br.com.iniflex.service.FuncionarioService;
import br.com.iniflex.util.UtilFormatacao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ImprimirNoConsole {

    private final UtilFormatacao fmt;

    public ImprimirNoConsole(UtilFormatacao fmt) {
        this.fmt = fmt;
    }

    public void titulo(String texto) {
        System.out.println();
        System.out.println("== " + texto + " ==");
    }

    public void imprimirFuncionarios(List<Funcionario> lista) {
        for (Funcionario f : lista) {
            System.out.printf("%-10s  %-10s  %-12s  %-15s%n",
                    f.getNome(),
                    f.getDataNascimentoFormatada(),
                    fmt.moeda(f.getSalario()),
                    f.getFuncao());
        }
    }

    public void imprimirAgrupados(Map<String, List<Funcionario>> grupos) {
        grupos.forEach((funcao, lista) -> {
            System.out.println("- " + funcao);
            for (Funcionario f : lista) {
                System.out.println("   " + f.getNome() + " (" + fmt.moeda(f.getSalario()) + ")");
            }
        });
    }

    public void imprimirIdades(List<Funcionario> lista) {
        for (Funcionario f : lista) {
            int idade = FuncionarioService.idade(f.getDataNascimento());
            System.out.println(f.getNome() + " - " + idade + " anos");
        }
    }

    public void imprimirNomes(List<Funcionario> lista) {
        for (Funcionario f : lista) {
            System.out.println(f.getNome());
        }
    }

    public void imprimirTotal(BigDecimal total) {
        System.out.println(fmt.moeda(total));
    }

    public void imprimirSalariosMinimos(Map<Funcionario, BigDecimal> mapa) {
        mapa.forEach((f, qtd) ->
                System.out.println(f.getNome() + " - " + qtd.toPlainString() + " salários mínimos")
        );
    }
}