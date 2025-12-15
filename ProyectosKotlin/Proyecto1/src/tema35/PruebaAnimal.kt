package tema35

fun main(args: Array<String>) {
    val animales : Array<Animal> = arrayOf(Animal("Zeus", "234-2454", "Gato"),
        Animal("Canelo", "231-2454", "Perro"),
        Animal("Perriqito", "341-2454", "Agapornis"),
        Animal("Blanquito", "456-2454", "Gato"))

    println(animales[0].nombre)
    println(animales.get(0).chip)


    animales.forEach ({ it: Animal -> println(it.toString()) })
    animales.forEach {println(it.toString()) }

    println("Introduzca especie:")
    var especie = readln().toString()
    println("Numero de gatos: ${animales.count{it.especie == especie}}")
}