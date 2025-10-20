package tema23

fun main(args: Array<String>) {
    val alumno: Alumno = Alumno("Antonio","1DAW", 20)

    println("Nombre: ${alumno.nombre}, \nCurso: ${alumno.curso}, \nEdad: ${alumno.edad}")

    alumno.nombre = "Federico"
    alumno.curso = "2daw"
    alumno.edad = 33

    println("Nombre: ${alumno.nombre}, \nCurso: ${alumno.curso}, \nEdad: ${alumno.edad}")


    val alumno02: Alumno02 = Alumno02("Federico","1DAW", 20)
    println("Nombre: ${alumno02.nombre}, \nCurso: ${alumno02.curso}, \nEdad: ${alumno02.edad}")

    var alumno03: Alumno03 = Alumno03()
    println("Nombre: ${alumno03.nombre}, \nCurso: ${alumno03.curso}, \nEdad: ${alumno03.edad}")
    alumno03  = Alumno03("Jacinto", edad = 24)
    println("Nombre: ${alumno03.nombre}, \nCurso: ${alumno03.curso}, \nEdad: ${alumno03.edad}")

    var alumno04 = Alumno04("Adrian", "1SMR", 16)
    println("Alumno 4 con parámetros: ${alumno04.nombre}, \nCurso: ${alumno04.curso}, \nEdad: ${alumno04.edad}")

    alumno04 = Alumno04()
    println("Alumno 4 sin parámetros: ${alumno04.nombre}, \nCurso: ${alumno04.curso}, \nEdad: ${alumno04.edad}")

    alumno04 = Alumno04("Jesusito")
    println("Alumno 4 con 1 parámetro: ${alumno04.nombre}, \nCurso: ${alumno04.curso}, \nEdad: ${alumno04.edad}")


}