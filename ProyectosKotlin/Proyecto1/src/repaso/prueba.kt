package repaso

fun main (args: Array<String>) {
    val alumno = Alumno("Juan", "1DAW", arrayListOf(5.0, 3.0,6.0, 8.0, 4.0))

    println("Numero notas: " + alumno.numeroNotas())

    println("Nota media: " + alumno.mediaNotas1())
    println("Nota media: " + alumno.mediaNotas2())
    println("Nota media: " + alumno.mediaNotas3())

    println("Nota numero aprobadas: " + alumno.numeroAprobadas1())
    println("Nota numero aprobadas: " + alumno.numeroAprobadas2())

    println("Nota numero suspensas: " + alumno.numeroSuspensas())

    println("Media de las notas aprobadas: " + alumno?.notas?.filter { it >= 5 }?.average())

    println(alumno.imprimirNotas())
    alumno.quitarNota2(8.0)
    println(alumno.imprimirNotas())
}