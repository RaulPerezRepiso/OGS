package tema31

object Matematica {
    val PI = 3.1416
    val E = 2.79
    fun aleatorio(minimo: Int, maximo: Int) = ((Math.random() * (maximo + 1 - minimo)) + minimo).toInt()
}