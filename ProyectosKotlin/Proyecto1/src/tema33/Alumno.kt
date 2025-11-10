package tema33

class Alumno (nif : String, nombre: String, var curso : String, override var tipo : Char) : Persona(nif, nombre), Beca {
    override fun mostrar() = "Nif : $nif Nombre : $nombre curso : $curso"
    //override var tipo: Char = tipo



    override fun tipo(): String = when (this.tipo) {
        'c' -> "comedor"
        't' -> "transporte"
        'r' -> "residencia"
        else -> "error"
    }


}