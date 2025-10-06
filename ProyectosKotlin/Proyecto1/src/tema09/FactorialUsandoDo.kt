package tema09

fun main(array: Array<String>) {
    var numero : Int
    var cont = 1
    var resultado = 1

    println("Introduzca número: ")
    numero = readLine()?.toInt() ?: 0

    do {
        resultado *= cont

        cont++
    }while (cont <= numero)

    println("Resultado: $resultado")
}