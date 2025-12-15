package tema35

fun main(args: Array<String>) {
    // array de 10 enteros que almacena los 10 primeros pares
    val enteros : IntArray = IntArray(10,{ println (it)
                                                      2 * it + 2})

    enteros.forEach ({println(it)})
    enteros.filter {it >= 10}.forEach {println(it)}

    enteros.sortedArrayDescending().forEach {println(it)}
}