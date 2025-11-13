package tema42


fun sumaEnteros (vararg numero: Array<Int>) : Int {

    var resultado = 0
    for ( valor in numero) {
        resultado += valor
    }
    return resultado
}

fun sumaEnteros2 (producto
                  : Int, vararg numeros : Int) : Int {

    var resultado = 0


    for ( valor in numeros) {
        resultado += valor
    }
    return resultado * producto
}

fun mezcla (vararg numeros : Int, valor : String) : Int =  8
fun main(args: Array<String>) {

    println(unidad42.sumaEnteros(2, 3, 56, 44, 10))
    println(sumaEnteros2(10, 2,3, 56, 44,10))
    println(mezcla(10, 2, 3, 56, 44,10, valor = "dfas"))

    var arrayEnteros  : IntArray = intArrayOf(1,2,3,4,5)

    println(unidad42.sumaEnteros(*arrayEnteros))
}
