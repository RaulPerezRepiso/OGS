package Examen2023.Ejer5

import tema23.Alumno02

class Asociacion(var s1: Socio, var s2: Socio, var s3: Socio) {
    fun mostrar(){
        var socios = arrayOf(s1, s2, s3);

        var mayorAntiguedad = 0
        var socioAntiguo: Socio? = null

        // Recorremos con forEach
        for (i in socios) {
            if (i.antiguedad > mayorAntiguedad) {
                mayorAntiguedad = i.antiguedad
                socioAntiguo = i
            }
        }

        println("El socio con mayor antigüedad es: ${socioAntiguo?.nombre}")
    }
}

fun main(){

    val socio1 = Socio("Raul", 5)
    val socio2 = Socio("Ana", 10)
    val socio3 = Socio("Luis", 7)

    val asociacion = Asociacion(socio1, socio2, socio3)

    // Mostrar el socio más antiguo
    asociacion.mostrar()
}
