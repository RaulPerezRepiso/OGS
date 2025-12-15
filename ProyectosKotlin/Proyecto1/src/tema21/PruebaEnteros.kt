package tema21

// Rellenar el array y calcular

fun leerArray (IntArray: IntArray) {
    for(con in IntArray.indices) {
        IntArray[con] = readLine()!!.toInt()
    }
}

fun escribirArray (IntArray: IntArray){
    for(con in IntArray) {
        println(con.toString())
    }
}

fun media (intArray: IntArray): Int = intArray.sum()/intArray.size

fun main(array: Array<String>) {

// Asigno posición con funcion lambda
//    var notas : IntArray = IntArray(5, init={ p : Int -> p })


// Asigno posición con funcino lambda por defecto
    var notas: IntArray= IntArray(size =5, init = {it+1})

    println("Asignacion a posición")
    escribirArray(notas)

    println("Introduzca notas: ")
    leerArray(notas)

    println("Hemos leido")
    escribirArray(notas)

    println("El sumatorio ${notas.sum()} Media ${media(notas)}")


    for ((indice, valor)in notas.withIndex()){
        println("$indice - $valor")
    }

}