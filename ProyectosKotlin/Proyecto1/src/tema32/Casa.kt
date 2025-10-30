package tema32


interface Casa {
    var direccion: String
    var superficie : Double
    fun calcular() : Double
    fun imprimir() : String {
        return direccion + " " + superficie
    }
}