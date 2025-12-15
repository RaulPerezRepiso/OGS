package tema32

class CasaMovil (matricula1 : String, marca : String, modelo : String,  direccion : String, superficie : Double) :
    Vehiculo(matricula1, marca, modelo) , Casa, Base {
    override var direccion: String = direccion

    override var superficie: Double = superficie

    override fun calcular() : Double {
        return superficie * 100
    }
    override fun imprimir (): String {
        return super<Casa>.imprimir() + " " + super<Vehiculo>.imprimir()

    }

}