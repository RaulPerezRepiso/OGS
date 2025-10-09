package tema14

fun sumatorio (numero: Int): Int {
    var result = 0
    for (i in 1..numero) {
        result += i
    }
    return result
}

fun factorail (numero: Int): Int {
    var result = 0
    for (i in 2..numero) {
        result *= i
    }
    return result
}

// Esta función se puede hacer con una línea
//fun abs(numero: Int): Int {
//    return if (numero < 0) -numero else numero
//}

fun abs (numero: Int): Int = if (numero < 0) -numero else numero

fun main (args: Array<String>) {
    var numero : Int
    println("Introduzca número: ")
    numero = readLine()!!.toInt()

    println("El sumatorio: de $numero es: ${sumatorio(numero)}")
    println("El factorail: de $numero es: ${factorail(numero)}")

}

