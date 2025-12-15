package Examen2023

fun main(args: Array<String>){
    println("Introduzca un número")
    var numero = readLine()!!.toInt();


    if (numero<0) {
        println("El número tiene que ser positivo")
        numero = readLine()!!.toInt();
        return;
    }else {
    for(i in 1 .. numero){
        if(i%2==0){
            println(i);
        }
    }}


    // repetir hasta que el número sea válido y positivo
    /*do {
        println("Introduzca un número positivo")
        numero = readLine()?.toIntOrNull()

        if (numero == null) {
            println("Entrada inválida, intente de nuevo")
        } else if (numero < 0) {
            println("Inserte un número positivo")
        }
    } while (numero == null || numero < 0)

    // aquí ya tenemos un número positivo
    println("Números pares desde 1 hasta $numero:")
    for (i in 1..numero) {
        if (i % 2 == 0) {
            println(i)
        }
    }*/

}