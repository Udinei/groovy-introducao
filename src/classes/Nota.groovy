package classes

class Nota {
    Integer itens
    Double valor

    Nota plus(Nota nota){
        println "plus"
        Nota novo = new Nota()
        novo.itens = + this.itens + nota.itens
        novo.valor = + this.valor + nota.valor
        novo
    }


    Nota next(){
        println "next"
        this.itens += 1
        this.valor *= 2
        this
    }
}
