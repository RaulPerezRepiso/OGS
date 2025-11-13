package tema41

data class Complejo (var a : Int, var b : Int) {

    fun suma (op2 : Complejo) : Complejo = Complejo(this.a + op2.a, this.b + op2.b)
    operator fun plus (op2 : Complejo) :Complejo =  Complejo(this.a + op2.a, this.b + op2.b)
    operator fun minus (op2 : Complejo) :Complejo =  Complejo(this.a - op2.a, this.b - op2.b)
    operator fun times (op2 : Complejo) :Complejo =  Complejo(this.a * op2.a - this.b * op2.b,
        this.b * op2.a + this.a * op2.b)
    // a los numeros complejos se les puede sumar, restar, multiplicar enteros
    operator fun plus (op2 : Int) :Complejo =  Complejo(this.a + op2, this.b )
    operator fun minus (op2 : Int) :Complejo =  Complejo(this.a - op2, this.b )
    operator fun times (op2 : Int) :Complejo =  Complejo(this.a * op2, this.b * op2)
}