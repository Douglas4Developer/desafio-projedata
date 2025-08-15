package br.com.iniflex.app;

import br.com.iniflex.repo.RepositorioFuncionarioEmMemoria;
import br.com.iniflex.service.FuncionarioService;
import br.com.iniflex.util.UtilFormatacao;
import br.com.iniflex.view.ImprimirNoConsole;

import java.math.BigDecimal;
import java.time.Month;
import java.util.EnumSet;

public class App {

    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public void run() {
        RepositorioFuncionarioEmMemoria repositorioFuncionarioEmMemoria = new RepositorioFuncionarioEmMemoria();
        FuncionarioService funcionarioService = new FuncionarioService(repositorioFuncionarioEmMemoria);
        ImprimirNoConsole printer = new ImprimirNoConsole(new UtilFormatacao());

        // 3.2 Remover João
        funcionarioService.removerPorNome("João");

        printer.titulo("Lista de funcionários");
        printer.imprimirFuncionarios(funcionarioService.listarTodos());

        // 3.4 Aumento de 10%
        funcionarioService.aplicarReajustePercentual(new BigDecimal("10"));
        printer.titulo("Após reajuste de 10%");
        printer.imprimirFuncionarios(funcionarioService.listarTodos());

        // 3.5 / 3.6 Agrupar por função e imprimir
        printer.titulo("Agrupados por função");
        printer.imprimirAgrupados(funcionarioService.agruparPorFuncao());

        // 3.8 Aniversariantes 10 e 12
        printer.titulo("Aniversariantes (Outubro e Dezembro)");
        printer.imprimirFuncionarios(funcionarioService.aniversariantes(EnumSet.of(Month.OCTOBER, Month.DECEMBER)));

        // 3.9 Ordenar por idade
        printer.titulo("Do mais velho ao mais novo (nome, idade)");
        printer.imprimirIdades(funcionarioService.ordenadosPorIdade());

        // 3.10 Ordem alfabética
        printer.titulo("Ordem alfabética");
        printer.imprimirNomes(funcionarioService.ordenadosPorNome());

        // 3.11 Total dos salários
        printer.titulo("Total dos salários");
        printer.imprimirTotal(funcionarioService.totalSalarios());

        // 3.12 Salários mínimos por funcionário
        printer.titulo("Salários mínimos por funcionário");
        printer.imprimirSalariosMinimos(funcionarioService.salariosMinimosPorFuncionario(SALARIO_MINIMO));
    }
}