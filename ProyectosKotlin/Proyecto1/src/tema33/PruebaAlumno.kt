package tema33

fun main(args: Array<String>) {
    val alumno : Alumno = Alumno("123456778A", "Juanito", "2DAW", 't')
    println(" Nif: ${alumno.nif} Nombre: ${alumno.nombre} Curso: ${alumno.curso} tipo: ${alumno.tipo} ${alumno.tipo()}")
}