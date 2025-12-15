package tema11

fun main(array: Array<String>) {
    var numero: Int
    var cont = 1
    var resultado = 1

    println("Introduzca número: ")
    numero = readLine()?.toInt() ?: 0


    for (cont in 1..numero) {

        resultado *= cont
    }
    println("Resultado: $resultado")
    println()

    // Bucle for usando una variable de tipo range
    var rango : IntRange = 1..numero
    resultado = 1
    for (cont in rango) {
        resultado *= cont
    }
    println("Resultado: $resultado")
}