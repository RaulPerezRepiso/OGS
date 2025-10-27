package tema30

fun main (args: Array<String>) {
    val carta : Carta = Carta (Figura.SOTA, Palo.OROS)
    println(" Enumerado Normal")
    println("Figura: ${carta.figura} Palo: ${carta.palo}")

    carta.figura = Figura.TRES
    carta.palo = Palo.BASTOS

    println("Figura: ${carta.figura} Palo: ${carta.palo}")

    println("Enumerado figura valor")
    val cartaFV : CartaFV = CartaFV (FiguraValor.SOTA, Palo.OROS)

    println("Ordinal de sota: ${cartaFV.figura.ordinal} Nombre de la sota: ${cartaFV.figura.name}")
    println("Figura: ${cartaFV.figura.peso} ${cartaFV.figura.pesoBrisca}  ${cartaFV.figura} Palo: ${cartaFV.palo}")


    cartaFV.figura = FiguraValor.TRES
    cartaFV.palo = Palo.BASTOS

    println("Figura: ${cartaFV.figura.peso}  ${cartaFV.figura.pesoBrisca} ${cartaFV.figura} Palo: ${cartaFV.palo}")
    cartaFV.figura.pesoBrisca = 6
    println("Figura: ${cartaFV.figura.peso}  ${cartaFV.figura.pesoBrisca} ${cartaFV.figura} Palo: ${cartaFV.palo}")

    // recorrido de todas las figuras
    for (elemento in FiguraValor.values()){
        println("Ordinal ${elemento.ordinal} Name: ${elemento.name} peso: ${elemento.peso}")

    }

}
