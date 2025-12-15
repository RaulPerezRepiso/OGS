package tema42

import tema41.Equipo

fun sumaEnteros (vararg numero: Int) : Int {

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

/* función que se le pasa un equipo y una lista de enteros que son goles. Si es positivo indica gol marcado y si
es negativo indica gol encajado.
 */

fun anotarGoles (equipo : Equipo, vararg goles : Int) {
    for (gol in goles) {
        if (gol > 0)
            equipo.golesMarcados += gol
        else
            equipo.golesEncajados -= gol
    }

}


fun main(args: Array<String>) {

    println(sumaEnteros(2,3, 56, 44,10))
    println(sumaEnteros2(10, 2,3, 56, 44,10))
    println(mezcla(10, 2, 3, 56, 44,10, valor = "dfas"))

    var arrayEnteros  : IntArray = intArrayOf(1,2,3,4,5)

    println(sumaEnteros(*arrayEnteros))


    // creación y prueba con equipo

    val equipo = Equipo("Archidona", 0,0,0)
    println("Equido; $equipo")

    anotarGoles(equipo, 3,-2,2,0,1,-2,3,-3)

    println("Equido; $equipo")

    val eAntequera = Equipo("Antequera", 0,0,0)
    println("Equido; $eAntequera")

    anotarGoles(eAntequera)

    println("Equido; $eAntequera")

    anotarGoles(eAntequera)

    eAntequera.anotarGoles( 3,-2,2,0,1,-2,3,-3)

    println("Equido; $eAntequera")

    eAntequera.anotarGoles()

    println("Equido; $eAntequera")
}


