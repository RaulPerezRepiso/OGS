package inicio

// función que pide un numero y me calcula el inicio.factorial
fun factorial(num: Int): Int {
    var resultado: Int = 1
    for (veces in 1..num)
        resultado *= veces
    return resultado
}
fun main () {
    val numero : Int

    println("Numero: ")
    numero = readln().toInt()


    println("Resultado: ${factorial(numero)}")

}