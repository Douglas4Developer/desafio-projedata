# Iniflex – Teste Prático (Java)

## Sobre mim

Sou **Douglas Soares de Souza Ferreira**, desenvolvedor Java focado em arquitetura limpa, SOLID, testes e boas práticas. Experiência com Java/Spring, PostgreSQL, Kafka, SonarQube e microsserviços.

## O que foi feito

Implementação do desafio em **Java 17 (console)**, com separação por camadas:

* **domain**: `Pessoa`, `Funcionario`
* **repo**: `RepositorioFuncionarioEmMemoria` (dados iniciais), `FuncionarioRepository`
* **service**: `FuncionarioService` (regras de negócio)
* **view**: `ImprimirNoConsole` (saída)
* **util**: `UtilFormatacao` (moeda pt-BR)
* **app**: `App` (orquestra) e `Main` (ponto de entrada)

## Requisitos atendidos (resumo)

* Inserção dos funcionários na ordem solicitada
* Remoção do **João**
* Impressões com **data dd/MM/yyyy** e **moeda pt-BR**
* Reajuste salarial **+10%**
* **Map** por função e impressão agrupada
* Aniversariantes de **outubro** e **dezembro**
* Ordenação por **idade** e por **nome (Collator pt-BR)**
* **Total** dos salários
* Cálculo de **salários mínimos** (base **R\$ 1.212,00**)

## Como rodar

**IntelliJ IDEA**

1. Abrir o projeto.
2. Executar `br.com.iniflex.app.Main`.

<img width="1588" height="849" alt="image" src="https://github.com/user-attachments/assets/fee927a9-04a7-4a8f-a0a1-f5875ba601ea" />
 
## Decisões técnicas

* **BigDecimal** para valores monetários + `HALF_UP` (2 casas).
* **Locale pt-BR** para moeda e **Collator** para ordenação correta com acentos.
* **LinkedHashMap** no agrupamento para manter a ordem previsível.
