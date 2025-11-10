package tema35

fun main(args: Array<String>) {
    val cadenas : Array<String> = Array<String>(30,{it.toString()} )

    for (cadena in cadenas.filter{it < "3"} ) {
        println(cadena)
    }

}