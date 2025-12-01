package tema43

fun main(args: Array<String>) {
    // prueba del !!
    /*var entero : Int
    println("Introduzca entero")
    entero = readLine()!!.toInt()
    println(entero) */

    // prueba del ? en tipo y en cadena de metodos
    var entero : Int?
    println("Introduzca entero")
    entero = readLine()?.toInt() ?:  0
    println(entero)

}