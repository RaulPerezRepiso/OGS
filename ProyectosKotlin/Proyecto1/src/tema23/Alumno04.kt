package tema23

// Constructor múltiple
class Alumno04(var nombre:String, var curso:String, var edad:Int) {

    constructor(): this("por defecto","por defecto",0)

    constructor(nombre: String): this(nombre,"por defecto",0){
        println("Introduzca curso: ")
        curso = readln().toString()

        println("Introduzca edad: ")
        edad = readln()!!.toInt()

    }
}