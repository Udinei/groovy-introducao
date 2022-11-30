package aula

import classes.Cantor
import classes.Cliente
import classes.Comida
import classes.Conexao
import classes.Fatura
import classes.Funcionario
import classes.Funcionario2
import classes.Nota
import classes.Palco
import classes.Pedido

import classes.ProdutoGroovy
import classes.Relatorio
import classes.Somar
import classes.Tela
import classes.Teste
import classes.Torcida
import classes.Venda
import classes.Viajar

import groovy.sql.DataSet
import groovy.sql.Sql
import groovy.swing.SwingBuilder
import groovy.xml.MarkupBuilder
import org.junit.jupiter.api.Test
import classes.Cliente as Xu

import javax.swing.JFrame
import javax.swing.JOptionPane
import java.awt.BorderLayout

import static java.util.Calendar.*


import static javax.swing.JFrame.EXIT_ON_CLOSE as ex

class Exercicios {

/*
   static main(args){
       println "Ola mundo goovy"
       String  nome = "Fernando"
       int idade = 36
       // interpolação(concatenação) de string usando $
       String frase = " O $nome tem $idade anos"
    }*/


    @Test
    void exercicio1ponto2() {
        int a = 10
        println a.class
        println a.toString()
        println 12l.class.name

        println 11g.class.name

        BigDecimal valor = 200.50
        println valor

    }

    @Test
    void exercicio2() {
        Cliente c = new Cliente()
        c.setNome "Fer"
        c.setData new Date()

        println c.somar(10, 10)
        println c.getNome() + " - " + c.getData()

    }

    @Test
    void exercicio3() {
        Cliente c = new Cliente()
        println c.getNome() + " - " + c.getData()

        c = new Cliente(nome: "Fernando")
        println c.getNome() + " - " + c.getData()

        c = new Cliente(data: new Date())
        println c.getNome() + " - " + c.getData()

        c = new Cliente(nome: "Fernando", data: new Date())
        println c.getNome() + " - " + c.getData()


    }


    @Test
    void exercicio4() {
        Cliente c = new Cliente(nome: "Udinei", data: new Date())
        println c.getNome()
        println c.getData()

        println c["nome"]
        println c["data"]

        c["nome"] = "Marcao"
        println c["nome"]
    }

    @Test
    void exercicio5() {
        //Produto p = new Produto("CD", 12.0)
        ProdutoGroovy p = new ProdutoGroovy(nome: "CD", valor: 10)
        println p.nome
        println p.nome = "Calcinha preta"
        p.valor = 15.0
        println p.nome + " - " + p.valor
    }

    @Test
    void exercicio6() {
        Xu c = new Xu(nome: "ddline", data: new Date())
        println c.nome

        println ex
    }

    @Test
    void exercicio7() {
        Venda v = new Venda()
        println v.vender(100)
        println v.vender(100, 15)

    }

    /*
    Array Optional Parameter – utilizado para passar parâmetros de um  array de forma simples, utilizando
    simplesmente virgula em vez de um array. Groovy gera dinamicamente a criação do array e passagem correta do
     método
    */

    @Test
    void exercicio8() {
        Somar soma = new Somar()
        println soma.somar(10)
        println soma.somar(10, 10)
        println soma.somar(10, 10, 10)

    }

    /*
    Safe Navegador Operator – utilizado para evitar NullPointerException quando das referencias para objetos “?”.
    Gera um if dinamicamente para testar se o objeto não esta  null e executa após o ? caso o método desejado
     caso não seja null. E não executa caso seja null.
    */

    @Test
    void exercicio9() {
        Cliente c = null
        c?.nome = "Udinei"
        println c?.getNome()

        Cliente c2 = new Cliente()
        c2?.nome = "Fernando"
        println c2?.getNome()
        println c2?.nome
    }


    /*
    Spread Operator – Usado pra executar comportamento em blocos de coleções, usa o operador “safe ?” por
    padrão(semelhando ao for, while..). Não estoura exception caso um elemento da coleção esteja null.
    * */

    @Test
    void exercicio10() {
        List<String> colecao = new ArrayList<>()
        colecao.add("udinei")
        colecao.add(null)
        colecao.add("anny")
        colecao.add("rita")

        // java
        /*   for(String item: colecao){
            if(item != null){
                item = item.toUpperCase()
            }
        }*/

        // Groovy
        colecao = colecao*.toUpperCase()
        println colecao

        colecao = colecao*.replace("A", "@")
        println colecao

    }


    /**
     Checked exceptions(exeção checadas) – São opcionais, não é necessário usar try/catch
     Fica a cargo do programador usar try/catch. O código deve ser coberto por testes unitários evitando
     assim maiores problemas.
     */
    @Test
    void exercicio11() {
        URL url = new URL("http://www.google.com.br")
        println url
    }

/**
 * Boolean Avaluation  - Utilizado para avaliar qualquer tipo de expressão como resultado boolean.
 * */
    @Test
    void exercicio12() {
        String nome = null;
        if (nome) {
            println true
        } else {
            println false
        }

        nome = "Udi"
        if (nome) {
            println true
        } else {
            println false
        }
        //-----
        int valor = 0
        if (valor) {
            println true
        } else {
            println false
        }
        valor = 1

        if (valor) {
            println true
        } else {
            println false
        }

        // ---
        List<String> colecao = new ArrayList()
        if (colecao) {
            println "colections com itens"
            println true
        } else {
            println "colections"
            println false
        }

        colecao.add("Udi'")
        if (colecao) {
            println "colections com itens"
            println true
        } else {
            println "colections vazia"
            println false
        }
    }


    /*
    Operator OverLoading – utilizado para criar expressões de operadores matemáticos ou lógicos, com qualquer
    tipo de objeto.(melhora a expressividade e otimização), os métodos da tabela abaixo podem ser
    mapeados em um objeto.
    **/

    @Test
    void exercicio13() {
        Nota n1 = new Nota(itens: 2, valor: 20)
        Nota n2 = new Nota(itens: 2, valor: 20)

        Nota n3 = n1 + n2 // equivale n3 = n1.plus(n2)
        println n3.valor + " - " + n3.itens

        n1++ // equivale n1 = n1.next()
        println n1.valor + " - " + n1.itens

    }

    @Test
    void exercicio13ponto2() {
        // BigDecimal vl = new BigDecimal(10) - java
        BigDecimal vl = 10  // graovy
        println vl

        // BigDecimal x = vl.add(new BigDecimal(10)) - java
        vl = vl + 1
        println vl
        vl++
        println vl
        println vl - 5

        Date data = new Date()
        println data
        data++ // acrescenta + 1 dia
        println data
        data--
        println data
    }

    /**
     * ATS Transformations
     Trechos de códigos com base em anotations, inseridos de forma dinâmica durante a execução do programa
     * */
    @Test
    void exercicio14() {
        Funcionario f = new Funcionario(nome: "Udi", idade: 10, salario: 1500.59)
        println f
    }


    /**
     * @EqualsAndHashCode – Gera sobreposição automática dos métodos equals e hashcode
     * */
    @Test
    void exercicio15() {
        Funcionario2 f1 = new Funcionario2(nome: "Udi", idade: 10, salario: 10)
        Funcionario2 f2 = new Funcionario2(nome: "Udi", idade: 10, salario: 10)
        println f1.equals(f2)
        println f2.equals(f1)

    }


    /**
     * @Immutable – utilizada para design pattern de objetos imutáveis. A classe é dinamicamente gerada
     * somente com atributos
     * gets + toString + equals e hashCode, qualquer tentativa de alteração gera erro.
     * */
    @Test
    void exercicio16() {
        Pedido p = new Pedido(cliente: "Fernando", numero: 10)
        println p.cliente + " - " + p.numero
        println p

        p.cliente = "Fer"
    }


/*
/**
 * @Singleton – A classe é dinamicamente gerada apenas com 1 única instância, chamada instance, qualquer
 * tentativa de criar uma instancia um erro sera gerado.
 */

    @Test
    void exercicio17() {
        Conexao.instance.valor = 10
        println Conexao.instance.valor
        Conexao con = Conexao.instance
        con.valor = 11
        println Conexao.instance.valor

    }


    /*
    @builder  - Utilizado para desing pattern de objetos Builder, sem acesso sets aos atributos
    * */

    @Test
    void exercicio18() {
        Comida comida = Comida.builder()
                .fruta("marca")
                .bebida("coca cola")
                .doce("casadinho").build()

        println comida.fruta
        println comida.bebida
        println comida.doce
    }


    /**
     * Operador def - Utilizado para criar objetos de tipo indeterminado dinamicamente.
     * suporta qualquer tipo ao longo da execução do programa
     * */
    @Test
    void exercicio19() {
        def objeto = "texto"
        println objeto.getClass()

        objeto = 10
        println objeto.class

        objeto = 10.0
        println objeto.class

        objeto = new Nota(itens: 2, valor: 20)
        objeto.valor = 10
        objeto.itens = 1
        println objeto.valor
        println objeto.itens

        objeto = new Pedido(cliente: "Udinei", numero: 20)
        println objeto.class
    }

    /**
     * Operador def - Utilizado para criar objetos de tipo indeterminado.
     * */
    @Test
    void exercicio20() {
        def teste = new Teste()
        def v1 = teste.metodo("fer")
        println v1.getClass()
        println v1

        v1 = teste.metodo(5)
        println v1.getClass()
        println v1

        def data = new Date()
        v1 = teste.metodo(data)
        println v1.getClass()
        println v1

        v1 = teste.metodo(10.0)
        println v1.getClass()
        println v1
    }

/**
 * FOR-IN – Utilizado para trabalhar com coleções de objetos sem tipo, de tipagem dinamica que usam def
 * */
    @Test
    void exercicio21() {
        def colecao = new ArrayList<String>()
        colecao.add("Udi")
        colecao.add("any")

        for (item in colecao) {
            println item
        }

        colecao = new ArrayList<Integer>()
        colecao.add(10)
        colecao.add(20)

        for (item in colecao) {
            println item
        }

        colecao = "Fernando Groovy e Show!!"
        for (item in colecao) {
            println item.class
            println item
        }

        colecao = 10
        for (item in colecao) {
            println item.class
            println item
        }
    }


    /**
     * closures
     * */
    @Test
    void exercicio22() {
        // println metodo(10,10)
        def metodo = { int v1, int v2 -> v1 + v2 }
        println metodo(10, 10)
        println metodo(1, 2)
    }

    // criando metodos no padrão Java
    public int metodo(int v1, int v2) {
        v1 + v2
    }


    /** closures * */
    @Test
    void exercicio23() {
        def imprimir = { String v ->
            String temp = v.trim().replace("a", "@")
            temp = temp.toUpperCase()
            temp
        }

        println imprimir(" Fernado ")
        println imprimir("marta")

    }

    /** closures * */
    @Test
    void exercicio24() {
        def funcao = { v1, v2 -> v1 + v2 }
        def r1 = funcao(5, 5)
        println r1.class
        println r1

        def r2 = funcao("Udi", "nei")
        println r2.class
        println r2

        def r3 = funcao(10.50, 5.0)
        println r3.class
        println r3

    }

    /** closures * */
    @Test
    void exercicio25() {
        def limpeza = { texto -> texto.trim().replace("a", "@").replace(" ", "").capitalize() }
        def rel = new Relatorio()

        rel.emitir(" f e r n a n d o ", limpeza)
        rel.emitir(" J a n a ", limpeza)
    }


    /** closures * */
    @Test
    void exercicio26() {
        def rel = new Relatorio()

        // como a closure na classe Relatorio foi declarada como ultimo parametro é possivel,
        // PASSAR codigo que sera executado em tempo de execução podendo abaixo o seguinte na sua chamada
        rel.emitir("FERNANDO") { v -> v + " DA SILVA" }
        rel.emitir("FERNANDO") { a -> a.replace("N", "#") }
    }


    /** closures
     * Se a closure vai receber somente um parametro não é necessario informar aerofunction -> passando parametros, basta usar it
     * antes do unico parametro da funcao
     * **/
    @Test
    void exercicio27() {
        def rel = new Relatorio()
        // esse trecho:  rel.emitir("FERNANDO"){v -> v + " DA SILVA"} ficaria como abaixo:
        rel.emitir("FERNANDO ") { it + "DA SILVA" }
        rel.emitir("FERNANDO ") { it.reverse() }

    }

    /** interface com closures - quando uma interface possui somente um metodo - interface funcional, é possivel passar a implementação
     * do metodo, usando def, passado diretamente para a interface um closure como implementacao
     * */
    @Test
    void exercicio28() {
        Palco palco = new Palco()
        Cantor cantor = null // interface

        // o codigo atribuido def sera executado como a implementacao da interface
        def implementacao = { println "vou cantar" } // é possivel porque a interface possui somente um metodo
        // interface recebe a implementado
        cantor = implementacao
        cantor.cantar()

        palco.show(cantor)

        // a implementação tb pode ser feita, diretamente para a variavel de declaracao da interface en vez de usar def
        cantor = { println "agora vou chorar" }
        cantor.cantar()

        palco.show({ println "closure cantando como se fosse cantor" })
    }


    /** interface com closures - implementando interfaces com mais de um metodo - para interface não funcional,
     * ou seja com mais de um metodo, para tanto é necessario passar os metodos entre chaves[] na declaracao de def
     * e informar o nome dos metodos com :  e colocar sua implementacao entre {}* */
    @Test
    void exercicio29() {
        Torcida t = null
        def corintiano = [
                pular : { println 'curintia pulando' },
                gritar: { p -> println 'curintia - ' + p }
        ] as Torcida

        t = corintiano
        t.pular()
        t.gritar("vai aê")

        def porcada = [
                pular : { println "porco eoooo" },
                gritar: { p -> println "porcooooooo - " + p }
        ] as Torcida

        t = porcada
        t.pular()
        t.gritar("Verdão")
    }


    /** closures */
    @Test
    void exercicio30() {
        //static main(arg) {
        def tela = new Tela()
        tela.setVisible(true)
    }

    /** metaprogramação - adicionando metodos novos no OBJETO */
    @Test
    void exercicio31ponto1() {
        def fat = new Fatura()
        // criando nno objeto da classe dinamicamente um novo metodo chamado vender
        fat.metaClass.vender = { valor -> println "Venda no valor " + valor }
        fat.vender(10.00)
    }

    /** metaprogramação - adicionando novos metodo na CLASSE */
    @Test
    void exercicio31ponto2() {
        def f1 = new Fatura()
        //f1.faturar(10)

        // criando na CLASSE um novo metodo faturar
        Fatura.metaClass.faturar = { valor -> println "faturar no valor = " + valor }
        def f2 = new Fatura()
        f2.faturar(10)

        def f3 = new Fatura()
        f3.faturar(22)

    }

    /** metaprogramação - adicionando novos metodo na CLASSE */
    @Test
    void exercicio32ponto1() {
        def fat = new Fatura()
        //fat.nome = "Udinei"

        // adicionando atributo na classe
        fat.metaClass.nome = "Udinei"
        println fat.nome
        fat.nome = "Outra coisa"
        println fat.nome
    }


    /** metaprogramação - adicionando novos atributos na CLASSE */
    @Test
    void exercicio32ponto2() {
        def f1 = new Fatura()
//        f1.cliente = "teste"

        Fatura.metaClass.cliente = ""
        def fat = new Fatura()
        fat.cliente = "Luana"
        println fat.cliente
    }

    /** metaprogramação - adicionando novos metodo stastic na CLASSE */
    @Test
    void exercicio32ponto3() {
        Fatura.metaClass.static.impressao = { println "metodo estatico ok" }
        Fatura.impressao()
        def f = new Fatura()
        f.impressao()
    }


    /** metaprogramação - Polimorfismo override de metodos na CLASSE */
    @Test
    void exercicio32ponto4() {
        Viajar v = new Viajar()
        v.viajar("Curitiba", 10)

        // construindo o novo metodo
        def novoMetodo = { String lugar, BigDecimal valor ->
            valor += 3.5
            println "Novo preço $lugar sera $valor"
        }

        // sobrepondo orverride o novo metodo
        v.metaClass.viajar = novoMetodo
        v.viajar("São Paulo", 20)
    }

    /** metaprogramação - Expando - utilizado para criar varios tipos de classes tipo VO, DTO etc.. */
    @Test
    void exercicio32ponto5() {
        Expando cliente = new Expando()
        cliente.nome = "Udinei"
        cliente.idade = 50
        cliente.impressao = { println "Nome $nome idade é $idade" }
        cliente.impressao()
    }

    /** GTK - Bigdecimal .. */
    @Test
    void exercicio33() {
        def v1 = new BigDecimal("10.50") // em Java
        def v2 = 10.50  // em Groovy
        println v2.getClass().name

        def v3 = v1 + v2
        println v3.getClass()
        println v3

        v3 = v1 + v2
        println v3

        v3 = v1 * v1
        println v3

    }


    /** GTK - Uso de String - verificação de igualdade etc.. */
    @Test
    void exercicio34() {
        def v1 = "Udinei"
        def v2 = "Udinei"
        println v1.equals(v2) // Java
        println v1 == v2     // Groovy

        def v3 = v1 - "nei" // Groovy
        println v3
        v3 = "Udinei"
        v3.substring(3, 5) // java
        println v3

        String texto = "udinei"
        println texto.capitalize()
        // busca de indice de uma string
        println texto.findIndexOf({ it == "u" })

        String textoGrande = '''
              Meu texto grande
              É muito grande
              e não precisa de ficar usando + toda hora
         '''

        def nome = "udinei"
        def idade = 50
        def salario = 1555.90
        def sql = "insert into cliente(nome, idade, salario) values (${nome}, ${idade}, ${salario})"
        println sql
        println textoGrande
    }


    /** GTK - Date - + e - -= sobrecarregados na classe java.util.Date para operar em formato de dias */
    @Test
    void exercicio35() {
        def data1 = new Date()
        data1[YEAR] = 2010
        data1[MONTH] = 1
        data1[DATE] = 14
        println data1

        def data2 = new Date()
        data2[YEAR] = 2015
        data2[MONTH] = DECEMBER
        data2[DATE] = 1
        println data2

        // data maior ou igual
        if (data2.compareTo(data1) <= 0) { // java
        }

        if (data2 >= data1) { // groovy
            println "maior"
        }

        Date data = new Date()
        println data
        data += 1
        println data
        data++
        println data
        data--
        println data

        println data.format("dd/MM/yyyy hh:mm:ss")
    }


    /** GTK - loops */
    @Test
    void exercicio36() {
        10.times { println it }     // executa o 10 vezes e imprime de zero a 9
        1.upto(10) { println it }  // executa 10 vezes imprime na sequencia e 1 a 10
        5.downto(1) { println it } // executa invertido imprime de 5 ao 1
    }

    /** GTK - File I/O criacao e escrita de arquivos */
    @Test
    void exercicio37() {
        def x = new FileWriter("E:/1.txt").withWriter { e -> e.write("Udinei da Silva 1") }

        def a = new File("E:/2.txt")
        a.write("outro")

        def b = new File("E:/3.txt")
        b.text = "Linha 1"
        b.text = "Linha 2"

        5.times { b << "\nnova linha usando sobrecarga de operador " }

        def c = new File("E:/3.txt")
        println c.text // lendo o conteudo do arquivo 3.txt

        println c.readLines()*.toUpperCase()
        // lendo todas as linhas do file, retorna um array com os linhas separados por virgula

        new File("E:/3.txt").eachLine { linha -> println linha }

        // apagando arquivos criados anteriormente
        a.delete()
        b.delete()
        c.delete()
        new File("E:/1.txt").delete()

        new File("C:/").eachFile { println it.name }

    }

    /** GTK - Threads */
    // @Test
    // void exercicio38(){
    /*static main(args) {
        Thread.start { 10.times { println "rodando na outra thread" } }

    }*/

    /** GTK - JDBC */
    @Test
    void exercicio39() {

        // listando dados do cliente
        Sql con = Sql.newInstance("jdbc:hsqldb:file:D:/hsqldb/base;shutdown=true", "sa", "1234", "org.hsqldb.jdbcDriver")
        con.eachRow("select * from cliente") { p -> println p.id + " - " + p.nome + " - " + p.email }

        // criando um bean dinamico lista , retorna a mesmo lista acima, outra forma de fazer
        def lista = con.rows("select * from cliente")
        lista.each { cli -> println cli.email }

        // insert
        con.executeInsert("insert into cliente(nome, email) values ('groovy xuxu', 'groovy@groovy.com')")
        println "pulando...."
        con.eachRow("select * from cliente") { p -> println p.id + " - " + p.nome }

        //  usando Dataset para geração de SQL automatico
        DataSet tabela = con.dataSet("cliente")
        tabela.add(nome: "g2", email: "g@g.com") // gerando o SQL insert (ORM)
        con.eachRow("select * from cliente") { p -> println p.id + " - " + p.nome }
    }

    /** GTK - Manipulando Collections List, Set */
    @Test
    void exercicio40() {
        ArrayList<String> lista = new ArrayList() // java

        def lista1 = [1, 2, 3, 4] // Groovy nova forma de criação e inicializacao de listas
        println lista1.getClass().name

        def lista2 = ["Udi", "ne", "i", "da"]
        println lista2.getClass().name

        def lista3 = new ArrayList<BigDecimal>()
        lista3.add(1.50) // java atribuição

        lista3 << 10.50 // groovy atribuição
        lista3 << 20.50 // groovy atribuição

        // loop for each no groovy
        lista1.each { println it } // percore a lista e imprime cada elemento da lista
        lista2.each { println it }
        lista3.each { println it }

        def total = 0
        lista3.each { total += it } // somatoria , it representa cada elemento da lista
        print total

        def clientes = []
        clientes << new Cliente(nome: "Xico", data: new Date())
        clientes << new Cliente(nome: "Luana", data: new Date())
        clientes << new Cliente(nome: "Fernando", data: new Date())
        clientes << new Cliente(nome: "Anny", data: new Date())
        clientes << new Cliente(nome: "Luciano", data: new Date())

        // buscas em listas
        def achou = clientes.find{c -> c.nome.contains("Lu")}
        println achou

        def encontrados = clientes.findAll{c -> c.nome.contains("Lu")}
        encontrados.each{c -> println c}

        // classificação ordenanda pelo "nome" dos itens da lista
        clientes.sort{c1, c2 -> c1.nome.compareTo(c2.nome)}
        println clientes

        // trabalhando com Set, possui os mesmos metodos do List
        def set = clientes as Set // converte uma lista "clientes" em um Set
        println set.getClass().name
        set.each {c -> println c}

        // converte um Set em um List
        def lista4 = set as List

        // criando List e Set imutaveis
        def listaImmutavel = lista4.asImmutable()
        def setImmutavel = set.asImmutable()

        def listaSyn = lista4.asSynchronized()
        def setSyn = set.asSynchronized()

        // Transformação de collections em outra collections, Clientes em Funcionarios
        // retorna uma lista de funcionarios com o nome dos clientes atribuido ao nome do funcionario
        def func = clientes.collect{c -> new Funcionario(nome: c.nome)}
        println func
    }

    /** GTK - Manipulando Collections Map */
    @Test
    void exercicio40ponto2() {
      Map<String, String>  map = new HashMap<>() // java
      def mapa = [:] // Groovy
        println mapa.getClass().name

        //mapa.put("pai", "Fernando"); // java
        mapa["pai"] = "Fernando" // Groovy atribuicao de map
        mapa["mae"] = "Anny"

        println mapa


        mapa.get("pai") // java obtendo um valor do map
        println mapa["pai"] // Groovy
        println mapa["filha"]  // Groovy

        // Groovy - criando e já inicializando o map
        def pessoas = ["jonas": 10, "pedro": 11, "rebeca": 12]
        println pessoas

        // iteração em Map
        // acessando os valores
        println "acessando os valores"
        pessoas.values().each{ println it}

        // acessando as chaves
        println "acessando as chaves"
        pessoas.keySet().each {println it}

    }

    /** GTK - ObjectGraphBuilder Gera, HTML, JSON, XML ETC.. */
    @Test
    void exercicio41() {
        def writer = new StringWriter()
        def html = new MarkupBuilder(writer)
        html.html {
            head {title "Minha pagina"}
            body (id: "main")
            h1 "Tutilo"
            p "linha de texto"
            p {strong "outro texto"}
            a href : "pagina.html", "clique aqui."
        }
        println writer
    }

/** GTK - ObjectGraphBuilder Swingo.. */
   // @Test
   // void exercicio42() {
    static main(args) {
        SwingBuilder bld = new SwingBuilder()
        JFrame tela = bld.frame(title: "Tela", size: [300, 130],
               defaultCloseOperation: JFrame.EXIT_ON_CLOSE, locationRelativeTo: null){
            panel(constraints: BorderLayout.CENTER){
                label(text: "Nome")
                textField(id: "nome", columns: 20)
                label(text: "E-mail")
                textField(id: "email", text: "", columns: 20)
            }
            panel(constraints: BorderLayout.SOUTH){
                button(text: "Gravar", actionPerformed: {
                    JOptionPane.showMessageDialog(null,
                    "gravou nome:" + nome.text + " - email:" + email.text)
                    nome.text = ""
                    email.text = ""
                })
                button(text: "Fechar", actionPerformed: {System.exit(0)})
            }
        }
        tela.setVisible(true)
    }

}