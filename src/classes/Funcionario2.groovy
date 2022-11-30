package classes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * @EqualsAndHashCode – Gera sobreposição automática dos métodos equals e hashcode
 * */
@EqualsAndHashCode
class Funcionario2 {
        String nome
        Integer idade
        Double salario

}
