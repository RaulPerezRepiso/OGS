package tema12

// Pedimos una nota númerica y me devuelve un texto
// 0,1,2 MD 3,4 IN 5,6 SUF 7 BIEN 8 NOT 9 SOB 10 MH

fun main(args: Array<String>) {
    val nota : Int
    println("Introduce nota: ")
    nota = readLine()!!.toInt()

    when {
        nota < 0 -> println("Nota Invalida")
        nota <=2 -> println("MD")
        nota <=4 -> println("IN")
        nota <=6 -> println("SUF")
        nota <=7 -> println("BIEN")
        nota <=8 -> println("NOT")
        nota <=9 -> println("SOB")
        nota <=10 -> println("MH")
        else -> println("Nota Invalida")
    }
    when (nota){
        in 0..2 -> println("MD")
        3,4 -> {"IN"}
        5,6 -> {"SUF"}
        7 -> {"BIEN"}
        8 -> {"NOT"}
        9 -> {"SOB"}
        10 -> {"MH"}
        else -> println("Nota Invalida")
    }

    when (nota){
        in 0..2 -> "MD"
        3,4 -> "IN"
        5,6 -> "SUF"
        7 -> "BIEN"
        8 -> "NOT"
        9 -> "SOB"
        10 -> "MH"
        else -> "Nota Invalida"
    }

}