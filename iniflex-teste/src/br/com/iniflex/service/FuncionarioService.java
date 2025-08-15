package br.com.iniflex.service;

import br.com.iniflex.domain.Funcionario;
import br.com.iniflex.repo.FuncionarioRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Collator;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {

    private final FuncionarioRepository repo;
    private final Collator collator = Collator.getInstance(new Locale("pt","BR"));

    public FuncionarioService(FuncionarioRepository repo) {
        this.repo = repo;
    }

    public List<Funcionario> listarTodos() {
        return repo.findAll();
    }

    public void removerPorNome(String nome) {
        repo.removeByName(nome);
    }

    public void aplicarReajustePercentual(BigDecimal percentual) {
        BigDecimal fator = BigDecimal.ONE.add(percentual.divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP));
        for (Funcionario f : repo.findAll()) {
            f.setSalario(f.getSalario().multiply(fator).setScale(2, RoundingMode.HALF_UP));
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao, LinkedHashMap::new, Collectors.toList()));
    }

    public List<Funcionario> aniversariantes(Set<Month> meses) {
        return repo.findAll().stream()
                .filter(f -> meses.contains(f.getDataNascimento().getMonth()))
                .collect(Collectors.toList());
    }

    public List<Funcionario> ordenadosPorIdade() {
        List<Funcionario> copia = new ArrayList<>(repo.findAll());
        copia.sort(Comparator.comparing(Funcionario::getDataNascimento)); // mais velho primeiro
        return copia;
    }

    public List<Funcionario> ordenadosPorNome() {
        List<Funcionario> copia = new ArrayList<>(repo.findAll());
        copia.sort((a, b) -> collator.compare(a.getNome(), b.getNome()));
        return copia;
    }

    public BigDecimal totalSalarios() {
        return repo.findAll().stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public Map<Funcionario, BigDecimal> salariosMinimosPorFuncionario(BigDecimal salarioMinimo) {
        Map<Funcionario, BigDecimal> mapa = new LinkedHashMap<>();
        for (Funcionario f : repo.findAll()) {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            mapa.put(f, qtd);
        }
        return mapa;
    }

    public static int idade(LocalDate nascimento) {
        return Period.between(nascimento, LocalDate.now()).getYears();
    }
}