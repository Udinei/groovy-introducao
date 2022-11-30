package classes

import groovy.transform.builder.Builder

/*
@builder  - Utilizado para desing pattern de objetos Builder, sem acesso sets aos atributos
*/
@Builder
class Comida {
    String fruta
    String bebida
    String doce

}
