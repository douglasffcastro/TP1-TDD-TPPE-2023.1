# 1. Trabalho Prático 1 - Test-Driven Development

## 1.1. Enunciado
Seja o cenário descrito a seguir:

Cálculo da completude de informações estruturadas, aninhadas ou não:

Um sistema de informações deve, dentre várias outras atribuições, calcular o quão completa é uma informação que ele processa baseado em um modelo descritivo das informações sob análise. As informações são sempre tratadas como valores textuais, independentemente se o valor é de fato um texto ou não. Avaliar a completude, nesse caso, significa verificar a presença ou ausência de algum valor para o campo correspondente.

Um registro, i.e. um conjunto de informações científicas agregadas, é composto de vários campos, podendo cada um desses campos serem atômicos ou compostos em vários níveis. Exemplos:


Os campos aninhados podem ser agrupados seguindo duas regras lógicas bem conhecidas. A regra OU EXCLUSIVO estabelece que o campo raiz é considerado completo quando apenas um dos campos filhos está presente, qualquer um dos campos filhos agregados. A regra OU INCLUSIVO estabelece que o campo raiz é considerado preenchido quando pelo menos um campo filho está presente. O caso especial em que nenhum campo filho está presente é considerado como não-preenchido. Para o campo raiz ser considerado completo, todos os campos filhos devem estar presente.

Para o caso de campo atômico, ele é considerado completo se há um valor atribuído a ele.

O cálculo da completude de um registro é feito de maneira recursiva, de modo que o valor da completudo do campo pai de um registro é dado pelo valor da completude de seus filhos, considerando as regras apresentadas anteriormente.

## 1.2. Campos e Regras
### a. Campos atômicos:
- A1 - 20% - title
- A2 - 20% - publicationDate
- A3 - 20% - language

### b. Campos aninhados OR exclusivo:
- OE - 20% - Campos aninhados OR exclusivo: (1,0)(0,1) - 20% | (0,0)(1,1) - 0%
    - Author.identifier.lattes
    - Author.identifier.orcid

### c. Campos aninhados OR inclusivo:
- OI - 20% - Campos aninhados OR inclusivo: (0,0,0,0) - 0% | 20%
    - author.nationality
    - author.birthCountry
    - author.birthCity
    - author.birthState

### d. Calculo da Completude:

- Completude = A1 + A2 + A3 + OE + OI

## 1.3. Instalação e Instruções para execução
**Linguagem**: Java<br>
**Ferramentas**: IntelliJ, Maven e JUnit<br>

### a. Instale os pré-requisitos
  - Java 20.0.1
  - Maven 3.8.1
  - JUnit 5.9.2

### b. Execute os teste
Na IDE de sua preferência, execute o AllTestes que está no diretório test/java com coverage. Na demonstração abaixo, utilizei o IntelliJ.
![Screenshot from 2023-05-24 21-32-20](https://github.com/douglasffcastro/TP1-TDD-TPPE-2023.1/assets/69691521/680e8096-d60b-48b8-917f-2dec78864ebc)

## 1.4. Resultados
![Screenshot from 2023-05-24 21-33-02](https://github.com/douglasffcastro/TP1-TDD-TPPE-2023.1/assets/69691521/fc488cdc-2a50-4a63-a1e5-54f11ff38c21)
![Screenshot from 2023-05-24 21-33-32](https://github.com/douglasffcastro/TP1-TDD-TPPE-2023.1/assets/69691521/a666d606-7841-428a-a49c-1b86bd838752)
