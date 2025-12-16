package Examen

data class Planta2(var nombre:String, var humedades:ArrayList<Double>) {

    //e
    fun cadenaHumedades(): String {
        return humedades.joinToString("---")
    }

    fun cadenaHumedadesMayorQue(valor: Double): String = humedades.filter { it > valor }.joinToString("---")

    //f
    fun media(humedades: ArrayList<Double>): Double {
        return humedades.average()
    }

    // g)
    operator fun plus(humedad: Double): Planta2 {
        val nuevaPlanta = Planta2(this.nombre, this.humedades)
        nuevaPlanta.humedades += humedad
        return nuevaPlanta
    }

    // h)
    operator fun plus(otraPlanta: Planta2): Planta2 {
        val nuevaPlanta = Planta2(this.nombre, this.humedades)
        nuevaPlanta.humedades += otraPlanta.humedades
        return nuevaPlanta
    }

    // i)
    fun añadirArrayList(arr: ArrayList<Pair<Int, Double>>) {
        arr.forEach { (num, medida) ->
            repeat(num) { plus(medida) }
        }
    }

}