package aula

import groovy.sql.Sql

def valor = 10
    def resultado = 0
    valor.times {
        println it
        resultado += it
    }
    println resultado

Sql con = Sql.newInstance("jdbc:hsqldb:file:D:/hsqldb/base;shutdown=true", "sa", "1234", "org.hsqldb.jdbcDriver")
con.eachRow("select * from cliente") { p -> println p.id + " - " + p.nome + " - " + p.email }
