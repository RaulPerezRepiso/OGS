package Examen2023

fun main(args: Array<String>)  {

    println("Introduzca la distancia a recorrer");
    var distancia = readLine()!!.toFloat();

    println("Esta disponible el conductor 0 sí lo está y 1 si no lo está");
    var disponibilidad = readLine()!!.toBoolean();

    if(disponibilidad && distancia<=0.5){
    println("Puedes iniciar el recorrido");
    }else if (distancia<=0.5 && !disponibilidad){
        println("El conductor no está disponible");
    }else if(disponibilidad && distancia>=0.5){
        println("Debido a la distancia, se aplicarán tarifas más altas")
    }else
        println("Debido a la distancia el conductor no está disponible")

}