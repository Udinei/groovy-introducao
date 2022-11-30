package classes

import groovy.transform.ToString


/*
@ToString – sobreposição automática do método  toString()
*/
//@ToString(excludes = ["idade"])
@ToString(includeNames=true, excludes = "idade, salario")
class Funcionario {
    String nome
    Integer idade
    Double salario
}
