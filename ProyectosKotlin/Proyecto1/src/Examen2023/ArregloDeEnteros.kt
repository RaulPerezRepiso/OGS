package Examen2023

import kotlin.random.Random

// Primera función
fun procesarArray(arr: IntArray, accion: (Int) -> Unit) {
    for (elemento in arr) {
        accion(elemento)
    }
}
// Segunda función
fun main(args: Array<String>) {
    val numeros = IntArray(10) { Random.nextInt(0, 100) }
    println("Array generado: ${numeros.joinToString()}")


    var multiplosDe2 = 0
    procesarArray(numeros) { n ->
        if (n % 2 == 0) multiplosDe2++
    }
    println("Cantidad de múltiplos de 2: $multiplosDe2")

    var sumaMenores45 = 0
    procesarArray(numeros) { n ->
        if (n < 45) sumaMenores45 += n
    }
    println("Suma de elementos menores a 45: $sumaMenores45")
}