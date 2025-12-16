package Examen

data class Planta (var descripcion:String, var numeroMedidas:Int, var sumaTotalHumedades:Double) {

    //a

    // b) Sin operador plus
    fun agregarHumedad(humedad: Double) {
        this.sumaTotalHumedades += humedad
    }

    // b) Con operador plus
    operator fun plus(humedad: Double): Planta {
        val nuevaPlanta = Planta(this.descripcion, this.numeroMedidas, this.sumaTotalHumedades + humedad)
        return nuevaPlanta
    }

    // c)
    operator fun plus(humedades: DoubleArray): Planta {
        var nuevaPlanta = Planta(this.descripcion, this.numeroMedidas, this.sumaTotalHumedades)

        for (humedad in humedades) {
            nuevaPlanta += humedad
        }

        return nuevaPlanta
    }

    // d)
    fun media(): Double = if (numeroMedidas > 0) sumaTotalHumedades / numeroMedidas else 0.0

}