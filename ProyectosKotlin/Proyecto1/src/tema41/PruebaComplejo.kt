package tema41

import kotlin.times
import kotlin.toString

fun main(args: Array<String>) {
    var complejo1 = Complejo(4,5)
    var complejo2 = Complejo(3,3)

    var complejo3 = complejo1.suma(complejo2)



    println(complejo3.toString())

    var complejo4 = complejo1 + complejo2
    println("complejo1 + complejo2 = ${complejo4.toString()}")

    complejo4 = complejo1 + complejo2 + Complejo(2,2)

    println("complejo1 + complejo2 + Complejo(2,2)= ${complejo4.toString()}")

    println("complejo1 * complejo2= ${complejo1 * complejo2}")

    println("(4,5) + 8= ${Complejo(4,5) + 8} ")
    println("(4,5) * 8= ${Complejo(4,5) * 8} ")

    // esto falla
    //println("8 * (4,5)= ${8 * Complejo(4,5)} ")
}