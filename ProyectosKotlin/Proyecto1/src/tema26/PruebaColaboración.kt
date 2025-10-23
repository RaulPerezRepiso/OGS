package tema26

/* Tenemos la clase Boxeador (nombre, recibidos y pegados)

Queremos hacer la clase Comabate que tiene 2 boxeadores
y nos pide Puñetazo y le suma a cada uno en su sitio

Suponemos que te dan 10 golpes

*/

fun main(args : Array<String>){
    val boxeador1 = Boxeador("Juanito")
    val boxeador2 = Boxeador("Urtain")

    val pelea = Pelea(boxeador1, boxeador2)

    pelea.jugar(10)

    println(boxeador1.toString())
    println(boxeador2.toString())
}