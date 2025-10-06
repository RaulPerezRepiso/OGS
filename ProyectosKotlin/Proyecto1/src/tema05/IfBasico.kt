package tema05

fun main(){
    var numero1 : Int
    var numero2 : Int
    var resultado : String

    println("Introduzca Número1:")
    numero1 = readLine()?.toInt() ?: 0

    println("Introduzca Número1:")
    numero2 = readLine()?.toInt() ?: 0

    if (numero1 >= numero2){
        println("Primero mayor")
    }else{
        println("Segundo mayor")
    }

    resultado = if (numero1 >= numero2){
        println("Introduzca Texto")
        readLine().toString()
    }else{
        "Segundo mayor"
    }
    println(resultado)

    println(if (numero1 >= numero2) "Primero mayor" else "Segundo mayor")
    println("El resultado de la comparación es: ${if (numero1 >= numero2) "Primero mayor" else "Segundo mayor"}")
}