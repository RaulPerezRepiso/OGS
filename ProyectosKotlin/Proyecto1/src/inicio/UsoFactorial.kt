package inicio

import tema14.factorial

fun main(args: Array<String>){
    println("Introduzca número: ")
    var numero = readLine()!!.toInt()

    println("El factorial de número es: ${factorial(numero)}")
}