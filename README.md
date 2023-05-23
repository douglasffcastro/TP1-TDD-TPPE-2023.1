# Trabalho Prático 1 - Test-Driven Development

**Disciplina**: FGA0242 - Técnicas de Programação para Plataformas Emergentes - TP1 <br>
**Professor**: André Lanna

|Matrícula | Nome                     |
| -- |--------------------------|
| 17/0140571  | Douglas Farias de Castro |


## Enunciado do trabalho
Seja o cenário descrito a seguir:

Cálculo da completude de informações estruturadas, aninhadas ou não:

Um sistema de informações deve, dentre várias outras atribuições, calcular o quão completa é uma informação que ele processa baseado em um modelo descritivo das informações sob análise. As informações são sempre tratadas como valores textuais, independentemente se o valor é de fato um texto ou não. Avaliar a completude, nesse caso, significa verificar a presença ou ausência de algum valor para o campo correspondente.

Um registro, i.e. um conjunto de informações científicas agregadas, é composto de vários campos, podendo cada um desses campos serem atômicos ou compostos em vários níveis. Exemplos:

* Atômico: CPF
* Atômico: Matricula
* Atômico: Sexo
* Atômico: Email
* Composto: Nome
    * Atômico: PrimeiroNome
    * Atômico: NomeMeio
    * Atômico: UltimoNome

Os campos podem ser agrupados para criar novos campos formando uma árvore de campos para os registros. Essa árvore deve respeitar o modelo de dados sob análise. Exemplo:

* Composto: PessoaFisica
    * Composto: Nome
        * Atômico: PrimeiroNome
        * Atômico: NomeMeio
        * Atômico: UltimoNome
    * Atômico: CPF
    * Atômico: Matricula
    * Atômico: Sexo
    * Atômico: Email

Os campos aninhados podem ser agrupados seguindo duas regras lógicas bem conhecidas. A regra OU EXCLUSIVO estabelece que o campo raiz é considerado completo quando apenas um dos campos filhos está presente, qualquer um dos campos filhos agregados. A regra OU INCLUSIVO estabelece que o campo raiz é considerado preenchido quando pelo menos um campo filho está presente. O caso especial em que nenhum campo filho está presente é considerado como não-preenchido. Para o campo raiz ser considerado completo, todos os campos filhos devem estar presente.

Para o caso de campo atômico, ele é considerado completo se há um valor atribuído a ele.

O cálculo da completude de um registro é feito de maneira recursiva, de modo que o valor da completudo do campo pai de um registro é dado pelo valor da completude de seus filhos, considerando as regras apresentadas anteriormente.

## Campos e Regras
### Campos atômicos:
- title
- publicationDate
- language

### Campos aninhados OR exclusivo:
- Author.identifier.lattes
- Author.identifier.orcid

### Campos aninhados OR inclusivo:
- author.nationality
- author.birthCountry
- author.birthCity
- author.birthState

## Instalação e  Instruções para execução
**Linguagem**: Java<br>
**Ferramentas**: IntelliJ e Maven<br>