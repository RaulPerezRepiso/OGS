package tema05
/* Vamos a pedir dos números enteros que suponemos positivos
si n1>n2 vamos a devolver una formula n1 elvando a n2 es...
en caso negativo devolvemos no se puede hacer
 */

fun main(args: Array<String>) {
    val n1: Int
    val n2: Int

    println("Introduzca Número 1:")
    n1 = readLine()?.toInt() ?: 0

    println("Introduzca Número 2:")
    n2 = readLine()?.toInt() ?: 0

    val cadena = if (n1 > 0 && n2 > 0) {
        var resultado: Int = 1
        for (i in 1..n2)
            resultado *= n1
        "Número 1 elavado a Número 2 es $resultado"
    } else
        "No se puede realizar la operación"

    println(cadena)
}