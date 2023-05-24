# 1. Trabalho Prático 1 - Test-Driven Development

**Disciplina**: FGA0242 - Técnicas de Programação para Plataformas Emergentes - TP1 <br>
**Professor**: André Lanna

## 1.1. Estudante
|Matrícula | Nome                     |
| -- |--------------------------|
| 17/0140571  | Douglas Farias de Castro |


## 1.2. Enunciado do trabalho
Seja o cenário descrito a seguir:

Cálculo da completude de informações estruturadas, aninhadas ou não:

Um sistema de informações deve, dentre várias outras atribuições, calcular o quão completa é uma informação que ele processa baseado em um modelo descritivo das informações sob análise. As informações são sempre tratadas como valores textuais, independentemente se o valor é de fato um texto ou não. Avaliar a completude, nesse caso, significa verificar a presença ou ausência de algum valor para o campo correspondente.

Um registro, i.e. um conjunto de informações científicas agregadas, é composto de vários campos, podendo cada um desses campos serem atômicos ou compostos em vários níveis. Exemplos:


Os campos aninhados podem ser agrupados seguindo duas regras lógicas bem conhecidas. A regra OU EXCLUSIVO estabelece que o campo raiz é considerado completo quando apenas um dos campos filhos está presente, qualquer um dos campos filhos agregados. A regra OU INCLUSIVO estabelece que o campo raiz é considerado preenchido quando pelo menos um campo filho está presente. O caso especial em que nenhum campo filho está presente é considerado como não-preenchido. Para o campo raiz ser considerado completo, todos os campos filhos devem estar presente.

Para o caso de campo atômico, ele é considerado completo se há um valor atribuído a ele.

O cálculo da completude de um registro é feito de maneira recursiva, de modo que o valor da completudo do campo pai de um registro é dado pelo valor da completude de seus filhos, considerando as regras apresentadas anteriormente.

## 1.3. Campos e Regras
### 1.3.1. Campos atômicos:
- A1 - 20% - title
- A2 - 20% - publicationDate
- A3 - 20% - language

### 1.3.2. Campos aninhados OR exclusivo:
- OE - 20% - Campos aninhados OR exclusivo: (1,0)(0,1) - 20% | (0,0)(1,1) - 0%
    - Author.identifier.lattes
    - Author.identifier.orcid

### 1.3.3. Campos aninhados OR inclusivo:
- OI - 20% - Campos aninhados OR inclusivo: (0,0,0,0) - 0% | 20%
    - author.nationality
    - author.birthCountry
    - author.birthCity
    - author.birthState

### 1.3.4. Calculo da Completude:

- Completude = A1 + A2 + A3 + OE + OI

## 1.4. Instalação e Instruções para execução
**Linguagem**: Java<br>
**Ferramentas**: IntelliJ, Maven e JUnit<br>

### 1.4.1. Instale os pré-requisitos
  - Java 20.0.1
  - JUnit 5.9.2
  - Maven 3.8.1

### 1.4.2. Execute os teste
Na IDE de sua preferência, execute os testes do diretório test/java com coverage. Na demonstração abaixo, utilizei o IntelliJ.

## 1.4. Resultados

