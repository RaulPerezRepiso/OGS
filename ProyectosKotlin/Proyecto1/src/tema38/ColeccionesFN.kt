package tema38

import tema36.Mayor20

fun main(args: Array<String>) {
    // creación usando simplificación en la salida del último parametro de los parentesis
    val enteros1 = IntArray(10, {it})
    // es igual que enteros1
    val enteros2 = IntArray(10) {it}

    println(" igualdad entre enteros1 y enteros2")
    enteros1.forEach { print(it.toString() + "  ") }
    println("")
    enteros2.forEach { print(it.toString() + "  ") }


    // prueba de count contar pares e impares
    println("Pares : ${enteros1.count { it % 2 == 0}}  Impares: ${enteros2.count { valor: Int -> valor % 2 == 1}}  ")

    //prueba all si todos son positivos y si todos son pares
    println("Todos positivos ${enteros1.all{it >= 0}}  Todos Pares: ${enteros1.all{it % 2 == 0}} ")

    // Suma de los pares
    println("Suma de los pares: ${enteros1.filter ({it % 2 == 0}).sum()} ")

    // prueba de findlast el último par
    println("Ultimo par: ${enteros1.findLast{it % 2 == 0}}")

    // variebles locales y variables de instancia dentro de una función lambda
    // modificar los elementos de enteros1 multiplicando por una variable y vamos a sumarlos en en otra variable

    var multiplo = 3
    var pos = 0
    var suma = 0

    enteros1.forEach { enteros1[pos] *= multiplo
        suma += enteros1[pos]
        pos++
    }

    println("La suma es: $suma Pos : $pos")
    println("Enteros1: ${enteros1.forEach{print(it.toString() + "   ")}}")
}