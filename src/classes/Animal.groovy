package classes

/**
 * Trait – Interface e classe abstrata ao mesmo tempo. Facilita a criação de estruturas OO que tinham padrões muito verboso.
 * Misturando regras de interface + classes concretas abstratas (Permite fazer Herança multipla)
 * */
trait Animal {
    String nome
    abstract void pular()
    void falar(){
        println "Animal " + nome + "falando..."
    }

}