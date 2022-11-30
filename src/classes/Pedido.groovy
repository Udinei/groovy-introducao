package classes

import groovy.transform.Immutable

/**
 * @Immutable – utilizada para design pattern de objetos imutáveis. A classe é dinamicamente gerada
 * somente com atributos
 * gets + toString + equals e hashCode, qualquer tentativa de alteração gera erro.
 * */
@Immutable
class Pedido {
    String cliente
    Integer numero
}
