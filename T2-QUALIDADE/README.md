# **1. Trabalho Prático 2 - Qualidade do Projeto de Código**

## **1.1. Enunciado**

### **a. Características de um bom projeto de software**
Não há projeto errado e projeto certo, há mau e bom projeto. Bons projetos possuem as seguintes características:
  * Simplicidade;
  * Elegância;
  * Modularidade (baixo acoplamento e alta coesão);
  * Boas interfaces; 
  * Extensibilidade;
  * Ausência de duplicidades; 
  * Portabilidade;
  * "Idiomático" (idioma da linguagem) e,
  * Boa documentação. 
  
### **b. Maus Cheiros de Código**
Em qualquer projeto de desenvolvimento de software, é crucial manter um código limpo e organizado. "Maus cheiros" de código referem-se a pontos no código onde é possível aplicar refatorações para melhorar a qualidade e a manutenibilidade do mesmo. Abaixo, apresentamos uma lista de alguns desses "maus cheiros":

  * Código duplicado
  * Método longo
  * Classe inchada
  * Lista de parâmetros longa demais
  * Mudanças divergentes
  * Cirurgia com rifle
  * Inveja de recursos
  * Aglomerados de dados
  * Obsessão primitiva
  * Instruções switcj
  * Hierarquias de herança paralelas
  * Classe preguiçosa
  * Generalização especulativa
  * Campo temporário
  * Cadeias de mensagens
  * Homem do meio
  * Intimidade inapropriada
  * Classes alternativas com diferentes interfaces
  * Biblioteca de classes incompletas
  * Classes de dados
  * Herança recusada
  * Comentários

### **c. Detalhamento do Enunciado**

As características de um bom projeto de software apresentadas acima estão, de
certo modo, associadas aos maus-cheiros de código apresentados por Martin Fowler
em seu catálogo de refatorações e relacionados às operações que tratam tais
maus-cheiros. De acordo com a definição do próprio Martin Fowler, refatoração é
uma maneira de **aperfeiçoar o projeto de código existente sem alterar o seu
comportamento externamente observável**. 

Para esse trabalho o grupo deverá escolher 5 características dentre as 9
características de um bom projeto de software apresentadas acima e, para cada
uma delas, apresentar:

  * Descrição da característica
  * Relação da característica com os maus-cheiros de código
  * Pelo menos uma operação de refatoração

## **1.2. Resultado**

### **a. Característica abordadas** 
Neste trabalho, abordaremos as seguintes características:

  * Simplicidade;
  * Elegância;
  * Extensibilidade;
  * Ausência de duplicidades;
  * Boa documentação. 
  
### **b. Simplicidade**

  - **Descrição**
  
    A simplicidade é a característica mais crucial em um código bem projetado. Um design simples é fácil de entender, livre de elementos desnecessários e de fácil implementação, mantendo coerência e consistência. Seguindo a ideia de Blaise Pascal, é essencial dedicar tempo para reduzir o código ao mínimo necessário, evitando complexidades que possam se entrelaçar de forma indesejada.

    O processo de design de software envolve tomar decisões difíceis como:

      * Extensibilidade x Simplicidade
      * Eficiência x Segurança
      * Quantidade de Recursos x Esforço de Desenvolvimento 
  
    Projetos requerem diferentes características prioritárias, por isso é fundamental estabelecer clareza nos requisitos desde o início. Buscar projetar de forma a adiar o trabalho o máximo possível e concentrar-se nos problemas imediatos é uma estratégia valiosa para atingir um código simples e eficaz. No entanto, alcançar a simplicidade é uma tarefa complexa, exigindo cuidadosa filtragem de informações e refatoração para chegar a uma solução final que, apesar de parecer óbvia, demandou muito pensamento para ser alcançada. Elementos como decomposição inadequada de componentes, proliferação descuidada de threads, escolha inadequada de algoritmos, esquemas de nomenclatura complexos e dependências excessivas entre módulos podem tornar o design desnecessariamente complexo, tornando o enfoque na simplicidade uma meta valiosa a ser perseguida.

  - **Relação com Maus Cheiros**
  
    Um código bem projetado e simples pode evitar muitos dos maus cheiros de código, como 
  
      * **Duplicações desnecessárias**, já que é incentivado a reutilização e modularização do código, evitando duplicações desnecessárias 
      * **Métodos longos e complexos**, uma vez que favorece a decomposição do código em métodos mais curtos e específicos, cada um responsável por uma tarefa bem definida
      * **Classes com muitas responsabilidades**, evitar que uma única classe acumule muitas funcionalidades, torna o código mais coeso. flexível e simples
  
    Outros maus cheiros que podem ter relação com um código com complexidade desnecessária são: lista de parâmetros longa demais, Mudanças divergentes, generalização especulativa, campos temporários não essenciais e intimidade inapropriada entre classes.

  - **Operações de Refatoração**

    Uma operação de refatoração que pode ajudar a atingir a característica de evitar classes com muitas responsabilidades e que torna o código mais simples é a Extração de Classe.
    
    Essa operação consiste em identificar parte do comportamento de uma classe que pode ser melhor representado como uma nova classe separada ou método, ou também quando um grupo de dados deve ser considerado em conjunto. Ao fazer isso, estamos dividindo as responsabilidades em duas classes distintas, tornando-as mais coesas e focadas em suas tarefas específicas.

### **c. Elegância**

  - **Descrição**
  
    A elegância representa os aspectos estéticos do design caminha juntp com a simplicidade. Significa que o código não é muito complexo ou confuso. O código bem projetado possui beleza em sua estrutura. Características desejáveis incluem evitar que uma única operação percorra todos os módulos e passe por múltiplas conversões de formato, além de partes complementando-se mutuamente e associando coisas similares. Um bom design depende do equilíbrio e da estética, em que a elegância e a simplicidade são fundamentais e sustentam a maioria das demais características.

    Um código bem projetado possui equilíbrio, evitando a complexidade desnecessária e destacando a beleza em sua estrutura. O controle do fluxo pelo sistema, a complementação entre as partes e a associação de coisas similares são exemplos das características desejáveis em um código bem projetado.

  - **Relação com Maus Cheiros**
  
    A característica da elegância no design de código tem uma relação direta com a prevenção de vários maus-cheiros de código definidos por Fowler:
  
      * **Código duplicado** dá abertura para reutilização de código, reduzindo as duplicações desnecessárias
  
      * **Método longo** torna o código menos conciso, proliferando métodos longos e complexos

    Outros maus cheiros associados: lista de parâmetros longa demais, mudanças divergentes, generalização especulativa, campo temporário e intimidade inapropriada.

  - **Operações de Refatoração**
  
    Uma operação de refatoração que pode levar o projeto de código a ter a característica de elegância é a Extração de Método.

    Essa operação consiste em identificar um trecho de código dentro de um método que realiza uma tarefa específica e bem definida. Em seguida, esse trecho é extraído para um novo método separado, com um nome significativo que descreve sua funcionalidade.

### **d. Extensibilidade**

  - **Descrição**

    Um código bem projetado permite que funcionalidades extras sejam adicionadas nos locais apropriados, quando necessário. No entanto, é preciso ter cuidado para evitar a criação de um código excessivamente complexo que tente antecipar qualquer modificação futura possível. A extensibilidade pode ser incorporada ao software através de estruturas como plug-ins, hierarquias de classes bem definidas, a disponibilização de funções de retorno úteis, entre outros.

    O conceito-chave é "projetar para extensibilidade". Um bom designer considera cuidadosamente como seu software será estendido e não deve adicionar aleatoriamente ganchos de extensibilidade, pois isso pode prejudicar a qualidade do código. É essencial equilibrar a funcionalidade necessária no momento, as adições que serão inevitáveis no futuro e as possíveis extensões, para criar um código bem estruturado e preparado para as mudanças que virão.

  - **Relação com Maus Cheiros**
  
    A característica de projetar para extensibilidade tem uma relação direta com a prevenção de diversos maus-cheiros de código definidos por Fowler:
   
    * **Lista de parâmetros longa demais**: O design para extensibilidade limita a quantidade de parâmetros, tornando o código mais claro e evitando tornar o código complexo demais.
  
    * **Mudanças divergentes**: Um design extensível busca manter o código coeso e com baixo acoplamento, reduzindo os pontos de mudança e evitando alterações conflitantes.
  
    Outros maus cheiros que podem estar presentes em código que não aplicam a extensibilidade: código duplicado, método longo, classe inchada e generalização especulativa.

  - **Operações de Refatoração**
  
    Uma operação de refatoração que pode ajudar a levar o projeto de código a ter a característica de projetar para extensibilidade é a Inversão de Dependência.

    Essa operação visa inverter as dependências entre classes, de forma que as classes de alto nível não dependam diretamente das classes de baixo nível, mas sim de abstrações ou interfaces. Isso permite que a adição de novas funcionalidades seja feita através da criação de novas implementações de interfaces, sem alterar as classes de alto nível.

### **e. Ausência de duplicidades**

  - **Descrição**
  
    Um código bem projetado evita repetições. A duplicação é inimiga de um design elegante e simples, levando a código redundante e desnecessário, o que torna o programa frágil e menos seguro. A duplicação muitas vezes surge através da prática de copiar e colar código. Ela pode surgir também quando programadores reinventam funcionalidades já existentes no sistema, por não compreenderem o todo. Para evitar isso, é importante generalizar código similar em uma função com parâmetros apropriados, garantindo que qualquer correção seja aplicada em um único lugar. Além disso, identificar classes muito similares pode indicar a necessidade de extrair funcionalidades comuns para uma superclasse ou criar uma interface que descreva o comportamento compartilhado.

    Interfaces apresentam ajudam esconder os detalhes de implementação e permite melhor organização. Essas interfaces podem assumir diversas formas, como bibliotecas, classes, funções, estruturas de dados e interfaces de sistemas operacionais e protocolos de comunicação em rede. Uma abordagem-chave para criar interfaces é "faça uma vez, faça bem feito, evite duplicação".
    
  - **Relação com Maus Cheiros**
  
    A característica de evitar duplicação no código está diretamente relacionada à prevenção de diversos maus-cheiros de código definidos por Fowler:

      * **Cirurgia com rifle**: Evitar duplicações permite que correções e melhorias sejam aplicadas em um único lugar, evitando problemas de consistência.

      * **Intimidade inapropriada**: A busca por evitar duplicação incentiva uma melhor separação de responsabilidades entre classes, reduzindo dependências excessivas e aumentando a coesão no código.

    Outros maus cheiros que podem estar presentes: Método longo, classe inchada, lista de parâmetros longa demais, mudanças divergentes e generalização especulativa.

  - **Operações de Refatoração**

    Uma peração de refatoração que pode ajudar a evitar a duplicação no projeto de código é a Extração de Superclasse.

    Essa operação é útil quando várias classes possuem atributos e comportamentos comuns, e você deseja evitar a duplicação de código, centralizando essas características em uma classe superior, conhecida como superclasse.

### **f. Boa documentação**
  - **Descrição**

    Um bom design deve ser documentado. Não deixe que os desenvolvedores tenham que inferir a estrutura por si mesmos. Isso é especialmente importante nos níveis mais altos do design. A documentação deve ser sucinta, pois o design é simples.

    Existem diferentes abordagens para a documentação, dependendo do nível de detalhe necessário. Em um extremo, os projetos arquiteturais são documentados em uma especificação. No outro extremo, funções empregam código autoexplicativo. A documentação é essencial para comunicar a estrutura e a lógica do design, tornando-o mais acessível para a equipe de desenvolvimento e futuras manutenções.

  - **Relação com Maus Cheiros**
  
    A característica de documentar o design tem uma relação direta com a prevenção de diversos maus-cheiros de código definidos por Fowler:

      * **Inveja de recursos**: Documentar o design pode auxiliar na identificação de classes que possuem dependências desnecessárias, evitando a proliferação de dependências inadequadas.

      * **Intimidade inapropriada**: Uma boa documentação pode ajudar a entender as interações entre as classes, evitando a exposição de detalhes internos desnecessários.

    Outros maus cheiros que se relacionam a essa característica: Código duplicado, método longo, classe inchada, lista de parâmetros longa demais e mudanças divergentes.


  - **Operações de Refatoração**
  
    Uma documentação bem elaborada facilita a colaboração, a manutenção e a evolução do projeto, garantindo que outros desenvolvedores possam entender rapidamente o que cada parte do código faz e como ela se integra ao sistema como um todo. É importante ressaltar que a documentação pode ser realizada incrementalmente ao longo do desenvolvimento. Incluir comentários e descrições relevantes nos cabeçalhos de classes e métodos é uma prática simples e valiosa. Dessa forma, a documentação cresce de forma consistente, refletindo as mudanças e evoluções do projeto, e contribui para um código mais claro, transparente e de fácil manutenção.

## **1.3. Referências**

  * Fowler, Martin. **Refactoring: Improving the Design of Existing Code**. Addison-Wesley, 1999.
  * GOODLIFFE, P. **Code Craft the practice of writing excellent code**. Hanbit Media Inc, 2007.
