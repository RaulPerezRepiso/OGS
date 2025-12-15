package tema33

fun main(args: Array<String>) {

    val persona : Persona
    var dato : String = "valor1"

    persona = object : Persona ("1234", "nombre") {
        override fun mostrar(): String = "Nif: $nif   Nombre: $nombre  $dato"
        }

    println(persona.mostrar())
    println(persona.nombre)

    dato = "valor2"
    println(persona.mostrar())

    }
