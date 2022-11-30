package classes

import groovy.transform.ToString

@ToString
class Cliente {
    String nome
    Date data

    Integer somar(Integer v1,Integer v2){
        v1 + v2
    }
}
