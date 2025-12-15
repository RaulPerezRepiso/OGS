package tema32

fun main(args: Array<String>) {
    var casaMovil : CasaMovil = CasaMovil("MA-2216-AJ", "Citroen",
        "C15", "Descampado", 3.5)
    println("La matricula es: ${casaMovil.matricula} ")

    println("Imprimir: ${casaMovil.imprimir()} ")
}
