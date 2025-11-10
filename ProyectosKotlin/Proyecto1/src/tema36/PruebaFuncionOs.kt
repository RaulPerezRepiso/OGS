package tema36

fun sumar (p1 : Int, p2 : Int) : Int = p1 + p2
fun multiplicar (p1 : Int, p2 : Int) : Int = p1 * p2
fun restar (p1 : Int, p2 : Int) : Int = p1 - p2

fun mayor20 (p : Int) : Boolean = p > 20

fun operar (p1 : Int, p2 : Int, f : (Int, Int) -> Int) : Int = f(p1, p2)

fun operar2 (p1 : Int, p2 : Int, f : (Int, Int) -> Int) : Int {
    return f(p1, p2)
}

fun main(args : Array<String>){
    println("prueba de función de orden superior con Función Lambda  11")
    println(operar(2,4, {a : Int , b : Int -> a*b + 3}))

    println("Prueba con llamada a sumar 6")
    println(operar(3,3, ::sumar))

    println("Prueba con llamada a restar para probar el orden de los parametros 4")
    println(operar(9,5, ::restar))

    var miFuncionL :  (Int, Int) -> Int = {a : Int , b : Int -> a*b + 3}



    println("Prueba con llamada a una varible que almacena una función lamba para probar el orden de los parametros 48")
    println(operar(9,5, miFuncionL))

    var miFuncionL2 :  (Int, Int) -> Int = ::sumar

    var mfArray : Array<(Int, Int) -> Int> = arrayOf(::sumar, ::restar, miFuncionL2, ::multiplicar)

    println("Resultado función lambda")
    println(miFuncionL(2,4))


    // como  se filtra
    val enteros : IntArray = IntArray(10, {i -> i*3})
    println("Enteros: ")
    for (i in enteros) {
        print(i.toString() + "  ")
    }

    println("Enteros mayores que 20: ")
    for (i in enteros.filter { it > 20 }) {
        print(i.toString() + "  ")
    }

    println("Enteros mayores con función que 20: ")
    for (i in enteros.filter (::mayor20 )) {
        print(i.toString() + "  ")
    }

    // filtro utilizando un objeto de un Interfaz
    val oMayor20 = object : Mayor20 {
        override fun mayor20 (p : Int) : Boolean = p > 20
    }


}