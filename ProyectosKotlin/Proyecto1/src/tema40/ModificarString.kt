package tema40

fun main(args : Array<String>) {

    var cadena1 : String
    println("Introduca cadena1: ")
    cadena1 = readLine().toString()

    println("Cadena1 doble: ${cadena1.doble()} ")
    println("cadena1 más 10 + : ${cadena1.añadir('+',10)}")
    println("Nuevo padEnd: ${cadena1.padEnd(20, '*')}")
}