## Projeto de estudo da linguagem Groovy
Esse projeto é um estudo introdutorio da linguagem Groovy. Tem como objetivo
o estudo dos principais recursos e vantagens de uso dessa linguagem.


### Ambiente de desenvolvimento

- Java 11.012
- Groovy 4.0.6
- hsqldb-2.6.1
- IntellJ
- 
## GROOVY
**Filosofia:**  
“ Ser a linguagem padrão Java do século 21, evoluída e acrescida com os determinados recursos modernos que não podem ser adicionados ou alterados na linguagem atual devido a retrocompatibilidade.”  

**Groovy** - Criada em 2003 Apache license Version 2.0, pela comunidade de desenvolvedores Java.
Groovy é uma linguagem dinâmica que adiciona, substitui ou remove comportamentos em 
tempo de execução, estendendo  classes e objetos.

Como caracteristica das linguagens dinamicas, não possui garantias de tipos e 
comportamentos  em tempo de compilação. O processo de verificação e  feito em 
tempo de execução, com isso traz mais flexibilidade e agilidade na criação e
manutenção de soluções de software e suas respectivas arquiteturas.

### 4 recursos que permitem criar dinamicamente com Groovy. 
1.	ATS Transformations
2.	Operador def
3.	Closures
4.	Metaprogramação (MOP)


### Benefícios

- Dinâmica, funcional com recursos de metaprogramação
- 50% a menos de código
- Usa tipagem dinâmica e ou estática (java é estática e fortemente tipada)
- Palavras reservadas: ***def, in e it***
- Agrega um rico ecossistema de produtos
- Integra 100% com qualquer framework Java do mercado
- Não é necessário criar ***gets e sets*** , Groovy cria dinamicamente esses métodos
- Não precisa digitar return de métodos, retorna o objeto que queira, basta coloca-lo  na
  ultima linha do metodo
- Não é necessário criar métodos construtores para Classes.
- Permite **interpolação(concatenação)** de string usando o caracter **$** 
- Não precisa usar ponto-virgula **(;)** no final da linha
- **Não precisa de parênteses** na chamada de métodos com um parâmetro, é opcional  (ex. prinln      
  “nome” em vez de println(“nome”))
- Arquivo tem que ter a extensão .groovy
- Groovy também executa código Java
- Tipos primitivos não existem em Groovy  todos são convertidos para Objeto.
- Não existe **sintaxe de array primitivos**
- Não existe a instrução loop **do/while**
- Não tem o modificador default
- Não tem  nível de visibilidade **package**
- Não tem **expressões lambdas do Java 8** tem funções especificas.
- Modificador de visibilidade caso não seja inserido o groovy coloca private para métodos e     public para métodos.
- **Curva de aprendizado baixa** para desenvolvedores Java
- Não tem limitação da preocupação com tipagens de dados, a tipagem é dinâmica ao longo da execução do programa, possui alta flexibilidade.
  GDK = JDK + Groovy API
- Exception – não são obrigatórias tratar com **try/catch**

### Evitando o DRY
- Pacotes lang do java já são todos importados automaticamente
- Todo tipo primitivo sera mapeado o para classe Wapper equivalente
- Todo float ou double são  convertidos para BigDecimal
  println 12l.class.name – cria BigDecimal (com o l apos o literal)
- Tipagem na compilação não garante que um objeto tenha determinado comportamento
println 11g.class.name – criar BigInteger (com o g apos o literal)  

### POGO  
- Semelhante ao POJO do Java, mas com caracteristicas proprias
- visibilidade public é padrão para classe e metodos, não precisa digitar.
- Todos atributos da classe é private por padrão
– Java é estática(validada em tempo de compilação) e fortemente  tipada.

##Conceitos Groovy
**Construct Names Arguments**  
– Gera dinamicamente todas as combinações de construtores em forma de mapa. Permitindo atribuir valores padrões  para cada atributo da classe.

**Subscript Operator**  
– Acessa e manipula os atributos de um objetos (via métodos get e set), de forma dinâmica(bind), utilizado para gerar estruturas dinâmicas.
Cliente c = new Cliente(nome: “fernando”, data: new Date())
Lendo um valor do objeto c[“nome”] em vez de c.getNome ou c[“nome”] = “Udinei”

**Direct Field Acess Operator**  
– Acessa os atributos da classe diretamente ex: Objeto.atributo  
O groovy faz um get ou set internamente, ele não acessa diretamente o atributo private.

**Operador as**
– usado para criar alias para usar jar de terceiros nos imports, reduzir tamanho de nomes de libs de terceiros etc..
Ex:
import classes.Cliente as Xu
Uso:
Xu c = new Xu(nome: “Udinei”)

**Optional Parameters** 
- utilizado para que o groovy preencha o parâmetro de um método com um valor padrão caso não seja passado nenhum valor.
Grovy gera dinamicamente todas as sobrecargas do método necessárias, pra cumprir os parâmetros opcionais.

Ex:
double vender(double valor, int taxa = 10){
double rs = valor * taxa / 100
rs
}


**Array Optional Parameter**  
– utilizado para passar parâmetros de um  array de forma simples, utilizando simplesmente virgula em vez de um array. Groovy gera dinamicamente a criação do array e passagem correta do método

**Safe Navegador Operator**  
– utilizado para evitar NullPointerException quando das referencias para objetos “?”. Gera um if dinamicamente para testar se o objeto não esta  null e executa após o ? caso o método desejado caso não seja null. E não executa caso seja null.
Ex:
objeto?.executar()
objeto?.setNome(“nome”)

**Spread Operator**  
– Usado pra executar comportamento em blocos de coleções, usa o operador “safe ?” por padrão(semelhando ao for, while..). Não estoura exception caso um elemento da coleção esteja null.
Ex:
colecao*.metodoHaSerChamado() – executado em cada elemento da coleção
coleção*.setNome(“bla”)

**Checked exceptions(exeção checadas)**  
– São opcionais, não é necessário usar try/catch
Fica a cargo do programador usar try/catch. O código deve ser coberto por testes unitários evitando assim maiores problemas.

**Boolean Avaluation**  
- Utilizado para avaliar qualquer tipo de expressão como resultado boolean.  
Regras: Valores padrão assumidos como verdadeiro    

Type - Condition for truth (verdadeiro)  
Boolean	- True  
Collection -	Not empty  
Character -	Value not 0  
CharSequence - Length greather than 0  
Enumeration	- Has more elements  
Iterator - Has next  
Number	Double  - value not 0  
Map	- Not empty  
Matcher	At - least one match  
Object[] - Length greater than 0  
Any other - type	Reference not null  

**Operator OverLoading**  
– utilizado para criar expressões de operadores matemáticos ou lógicos, com qualquer tipo de objeto.(melhora a expressividade e otimização), os métodos da tabela abaixo podem ser mapeados em um objeto.
- Devem ser públicos
- Devem nomeados exatamente como indicado na tabela
- Devem retornar o mesmo objeto do tipo operado a esquerda
- O parâmetro depende do tipo do objeto a direita do operador de forma que é possível operar com objetos diferentes
  Opções:
AQUI VAI IMAGEM

**Trait**  
Facilita a criação de estruturas OO que tinham padrões muito verboso.
Misturando regras de interface + classes concretas abstratas 
(Permite fazer Herança multipla)

Trait é uma interface que pode ter métodos abstratos, e é também uma classe abstrata 
que pode conter estado e métodos concretos.  

As outras classes usam o comando implements  para implementar um Trait herdando
todos os seus comportamentos, pode herdar outras Traid e outras interface usando 
o comando extends.  

Permite herança multipla, sobreposição e polimorfismo(Sobrecarga e sobreposição
são tipos de polimorfismo).  
Ver: conflito de herança múltiplas, http://www.groovy-lang.org/objectorientation.html#_traits

##Criando dinamicamente com  Groovy.
###1. ATS Transformations  
      Trechos de códigos com base em anotations  inseridos de forma dinâmica  
      **@ToString** – sobreposição automática do método  toString()  


 **Ex1:**
    O atributo idade não sera exibido ao chamar o toString.  

    
      @ToString(excludes = ["idade"])
      class Funcionario {
         String nome
         Integer idade
         Double salario
      }


**Ex2:** Coloca o nome do atributo no toString da classe  

    @ToString(includeNames=true)
    @ToString(includeNames=true, excludes = "idade, salario")
    class Funcionario {
       String nome
       Integer idade
       Double salario
    }

**@EqualsAndHashCode** Gera sobreposição automática dos métodos equals e hashcode.
Usando com design Pattern  

**@Immutable**  – utilizada para design pattern de objetos imutáveis. A classe
é dinamicamente gerada somente com atributos  gets + toString + equals e hashCode, qualquer tentativa de alteração gera erro.  

**@Singleton**  – A classe é dinamicamente gerada apenas com 1 única instância, 
chamada instance, qualquer  tentativa de criar uma instancia um erro sera gerado.  

**@builder** - Utilizado para desing pattern de objetos Builder, sem acesso sets aos
atributos

[Link para mais ATS transformtions:](https://www.groovy-lang.org/metaprogramming.html#_available_ast_transformations)



###2. Operador def
- Utilizado para criar objetos de tipo indeterminado.
- O objeto assume varias tipagens diferente ao longo da execução da solução.
- Utilizado para passagem de parâmetros e retorno de métodos.
- Ausência do tipo na passagem do parâmetro do método, já indica que o tipo e dinâmico.

 **FOR-IN**   
– Utilizado para trabalhar com coleções de objetos sem tipo, de tipagem dinamica que 
 usam def

###3.	Closures  
 Programação funcional é um paradigma de desenvolvimento de software que visualiza a computação como uma avaliação de funções matemáticas e que evita estado ou dados mutáveis.

- é anônimo sem nome
- é dinamicamente criando e executando
- é atribuído para uma variável def de que possa ser invocado e repasssdo como parâmetro para outra closures e ou metodos de objetos.
- se não informar o tipo do parâmetro será assumido o def como padrão  
   
    Ex:      **def metodo = {v1,v2 -> v1 + v2}**  


- Quando não se declara parâmetros numa closure, por default é assumido um parâmetro def chamado “it”, utilizado para otimizar e facilitar a programação.
  **Ex:  {def it -> }**

**Interfaces Groovy 1 (um método)**
- Clousures podem ser utilizadas para gerar implementação de interfaces polimórficas dinâmicas em tempo de execução, para gerar códigos elegantes, rápidos e flexíveis.  

**Interfaces Groovy  2 (vários métodos )** 
- Clousures  Podem ser utilizadas para gerar implementação de interfaces não funcionais com vários métodos, usando o operador “as”.
- 

**NOTA**:  
QUANDO USAR CLOSURE  
Closure não foram feitas para substituir um método de um objeto, elas foram criadas para encapsular pedaços de códigos pequenos e focados em executar “mini tarefas rotineiras” que não justifiquem se criar um objeto para isso. Podem ser utilizadas para fazer implementações dinâmicas para se encaixar em design patterns gerais.



##4.	Metaprogramação (MOP)
Em Groovy o metaclass pode ser alterado, e fica na memoria HEALP dentro do próprio objeto. Representando por um objeto chamado MetaClass;
Pode ser dinamicamente alterado através da propriedade “metaclass”.  

Dinamicamente é possível alterar a classe durante a execução da solução. É rápido, produtivo, dinâmico e flexível.

###5 opções de recursos para fazer metaprogramação
1. ExpandoMetaClass
2. Categoriees
3. Mixins
4. Expando
5. Compile time MOP

- A Linguagem dinâmica Groovy permite criar em tempo de execução propriedades, métodos, construtores e sobrepor métodos existentes.
Em java as informações de uma classe (metaclass) são carregadas no classloader da solução, e não podem ser alteradas.  
- O compilador garante que não sera executado coisas e comportamentos que a classe não consiga fazer 
- Somente o objeto a partir do ponto da alteração conterá esses novos comportamentos.
- Outros objetos da mesma classe não conterão as alterações somente o objeto em questão.
- Métodos dinâmicos não parecem no 'code completion'.
- Atributos dinâmicos não aparecem no 'code completion' e nem visualmente no ‘variables’ de depuração não consegue fazer (métodos e comportamentos)
- Podem ser inseridos dinamicamente métodos estáticos em classes, atributos static não podem ser criados dinamicamente no Groovy.
- É possível fazer override de metodos sendo que os parâmetros devem ser do mesmo 
tipo e na mesma sequencia, caso contrario o override não será aplicado e sim o overload.

 **1 Classe Expando (Dinamic bean)**  
 Criada especificamente para ser utilizado de forma mutante, 
para receber comportamentos dinâmicos em runtime. Com ela é possível criar objetos
chamados de “dinamic bean” utilizando para modelar objetos dinâmicos ao longo da
execução de uma solução Groovy. Evitando assim trabalho e burocracia tais como 
VO(value objetc), DTO (data tranfer object) .




##GDK – Groovy Development Kit
**Objetivo**  
Retirar o DRY, facilitar, automatizar rotinas repetitivas, burocráticas,
verbosas e trabalhosas que os programadores Java sempre tinham que fazer ao utilizar
as API clássicas básicas do java.  

Acrescentou centenas de novos comportamentos que não existe em varias classes da JDK.

Tais como:  
java.lang.*, java.io.*, java.util.*, java.math.*, java.sql.*, java.servlet.*, etc..    

**GDK possui recursos que facilita o uso de APIs: XML, JSON, SWING , HTML, etc...**
- Novos metodos em classes existentes da JDK
- novas classes, metodos de operator de overloading de classes JDK
- Closure em classes existentes da JDK
- Builder facilitadores de criação de objetos baseados em composições.
- Classes “Facades” facilitadores de serviços

**BigDecimal**  
Em groovy pode ser manipulado como se fosse um tipo de dado primitivo, mais rápido, conciso e orientado a objeto
Operadores: ==, +, *, -, +=, -=
Equals, somar, multiplicar etc.

**Loops no Groovy**  
    
    Java.lang.Integer -  qualquer numero  
    10.times{println it}     // executa o 10 vezes e imprime de zero a 9  
    1.upto(10) {println it}  // executa 10 vezes imprime na sequencia e 1 a 10  
    5.downto(1) {println it} // executa invertido imprime de 5 ao 1  
    
Manipulação de arquivos I/O no Groovy
Criar gravar e ler arquivos I/O


**Banco de dados JDBC, DataSet, Sql no Groovy**  
Incluir no path da IDE(Intellij) o driver de BD:  hsqldb.jar

AQUI VAI IMG  
Erro : user lacks privilege or object not found
Causa: foi informado “mem” em vez de “file” no path para o Banco de dados e o banco estava em arquivo “file” e não em memoria “mem”
Solução: Alterar o URL para file

**API Collections (List, Map e Set)**  
No groovy otimiza, traz mais rapidez e conveniências através do uso de closures





**ObjectGraphBuilder**   
Utilizado para otimizar a criação da repetição de “containers de objetos” um objeto dentro de outro objeto  

Ex: nós dos XML, JSON, SWING, HTML etc..  
Dominios de Venda: Cliente1 -> 1 Nota 1 -> N Itens de notas

**Script**  
Pedaço de um programa escrito em arquivo texto para ser executado por um ambiente especial que pode compilar, interpretar, e executar o programa
Podem ser executado de forma flexível e rápida.  

Limpeza ou rotinas de servidores, Jobs ou crons de SO, correções em banco de dados etc...


**Type checked (opcional)**   
O Groovy faz a compilação em tempo de desenvolvimento, para tanto:  

- Não use o perador def usando tipagem forte
- Não use nada que gere código dinâmico, como closures, ATS, Groovy Bean.
- Coloque @TypeChecked sobre as classes para fazer groovy checar a tipagem.

## Distribuição do projeto groovy

Deve ser acrescentado no projeto o arquivo jar **groovy-all.jar, que se encontra dentro do projeto

Adicionando Groovy em projetos existentes
Clicar em cima do nome do projeto com botão direito -> configure -> Convert to groovy project

Isso ira adicionar os jars e o plugin do groovy em qualquer tipo de projeto Java.

Inserindo o Groovy em projeto existente via intellij

