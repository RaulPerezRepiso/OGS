package tema23
/* Clase Alumno usa constructor Básico usando var
en la declarión de la clase
Vamos a introducir una nueva variable de instancia y la vamos a cargar desde teclado

 */
class Alumno05 (var nombre: String="", var curso: String="2DAW", var edad: Int=20) {
    val numero = readln()!!.toInt()
}