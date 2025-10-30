package tema32

open class Vehiculo (var matricula : String, var marca : String, var modelo : String){
    open fun imprimir(): String {
        return matricula + "  " + marca + "  " + modelo
    }
}