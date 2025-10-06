package tema04

fun main (args: Array<String>) {
    var entero : Int
    var cadena : String
    var cadenaNula : String?

    println("Introduzca cadenaNula:")
    cadenaNula = readLine().toString()

    println("Introduzca cadena:")
    cadena = readLine().toString()

    println("Introduzca entero:")
    entero = readLine()?.toString()?.toInt() ?: 18
}