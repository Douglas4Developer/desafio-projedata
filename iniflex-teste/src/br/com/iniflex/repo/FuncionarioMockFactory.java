package br.com.iniflex.repo;

import br.com.iniflex.domain.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

final class FuncionarioMockFactory {
    private FuncionarioMockFactory() {}

    static List<Funcionario> obterFuncionarios() {
        return List.of(
                new Funcionario("Maria",   LocalDate.of(2000,10,18), toBigDecimal ("2009.44"), "Operador"),
                new Funcionario("João",    LocalDate.of(1990,5,12),  toBigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio",    LocalDate.of(1961,5,2),   toBigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel",  LocalDate.of(1988,10,14), toBigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice",   LocalDate.of(1995,1,5),   toBigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor",  LocalDate.of(1999,11,19), toBigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur",  LocalDate.of(1993,3,31),  toBigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura",   LocalDate.of(1994,7,8),   toBigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloisa", LocalDate.of(2003,5,24),  toBigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena",  LocalDate.of(1996,9,2),   toBigDecimal("2799.93"), "Gerente")
        );
    }

    private static BigDecimal toBigDecimal (String n) { return new BigDecimal(n); }
}
