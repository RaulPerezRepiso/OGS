package tema18

// Función calcular el total con IVA de una base
// Suponemos que la mayoría de nuestros artículos tienen el IVA a 21
fun iva(base: Float, iva: Float=21f)= base*(iva/100.0f +1f)

// Sumar parametros
fun sumar(primero: Int, n1: Int =1, n2: Int =2, n3: Int =3, n4: Int =4, n5: Int =5):Int = primero + n1 + n2 + n3 + n4 + n5

// Función única para el area del cuadrado y rectangulo
fun area(l1: Int, l2: Int=l1): Int = l1*l2

fun main(args: Array<String>) {
    println("Introduzca base: ")
    var base = readLine()!!.toFloat()

    //Llamada Normal
    println("El total IVA de $base es: ${iva(base, iva=21.0f)} ")

    //Llamada con un parámetro y el otro coge valor por defecto
    println("El total IVA de $base es: ${iva(base)} ")

    //Llamada por nombre de parámetro
    println("El total IVA de $base es: ${iva(iva=21.0f, base = base)} ")

    //Prueba de sumar un solo parámetro
    println("Sumar con solo un parámetro un 8 es: ${sumar(8)}")

    //Prueba de sumar dos parámetros
    println("Sumar dos parámetros primero = 8 y n1 = 4 es: ${sumar(8, 4)}")
    println("Sumar dos parámetros primero = 8 y n4 = 14 es: ${sumar(8,n4 = 14)}")

    //Calcula area de cuadrdo/rectangulo
    println("Area cuadrado 5 ${area(5)}")
    println("Area rectangulo 5, 8 ${area(5, 8)}")


}