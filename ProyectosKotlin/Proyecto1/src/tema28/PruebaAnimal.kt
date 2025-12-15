package tema28

fun main(args: Array<String>) {
    val gato : Animal = Animal("gato", "felino", "Zeus")

    println("gato ${gato.especie}, ${gato.familia}, ${gato.nombre}")

    gato.especie = "gatito"

    println("gato ${gato.especie}, ${gato.familia}, ${gato.nombre}")
    println("Gato.toString() " + gato.toString())


}