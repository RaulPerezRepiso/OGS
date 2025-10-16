package tema14

fun sumatorio (numero: Int): Int {
    var result = 0
    for (i in 1..numero) {
        result += i
    }
    return result
}

fun factorial (numero: Int): Int {
    var result = 0
    for (i in 2..numero) {
        result *= i
    }
    return result
}
// funcion que no retonar datos
// es el tipo voi que en ky se usa el tipo Unit

// escribe desde 1 hasta el numero
// formato oficial
fun escribir (numero : Int){
   for (i in 1..numero) {
       println("$i -")
   }
}

// formato Unit
fun escribir1 (numero : Int): Unit{
    for (i in 1..numero) {
        println("$i -")
    }
}


// Esta función se puede hacer con una línea
//fun abs(numero: Int): Int {
//    return if (numero < 0) -numero else numero
//}

fun abs (numero: Int): Int = if (numero < 0) -numero else numero

fun negacion (boleano: Boolean): Boolean = !boleano

fun main (args: Array<String>) {
    var numero : Int
    println("Introduzca número: ")
    numero = readLine()!!.toInt()

    println("El sumatorio: de $numero es: ${sumatorio(numero)}")
    println("El factorail: de $numero es: ${factorial(numero)}")

}

