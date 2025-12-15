package Examen2024

data class Partido( var equipo_local:String, var equipo_visitante:String, var goles_local:Int, var goles_vis: Int) {

    //Ejercicio 2
    fun valido(liga: List<Equipo>): Boolean {
        if (goles_local >= 0 && goles_vis >=0)
            if(!equipo_local.equals(equipo_visitante, ignoreCase = true))
                liga.forEach(){
                    if(it.nombre.equals(equipo_local, ignoreCase = true)) {
                        liga.forEach(){
                            if(it.nombre.equals(equipo_visitante, ignoreCase = true))
                                return true
                        } } }
        return false}}

//Clase resultado equipo
data class ResultadoEquipo(var goles_marcados: Int, var goles_encajados: Int) {
}

//Main
fun main( args: Array<String>) {
    val liga : List<Equipo> =
        arrayListOf(Equipo("Madrid"),
            Equipo("Barcelona"),
            Equipo("Malaga"),
            Equipo("Alicante"),
            Equipo("Betis"),
            Equipo("Sevilla"))
    println(liga)

//Ejercicio 4
    println("Ingrese el Equipo Local")
    var equipo_local = readLine()!!.toString()

    println("Ingrese el Equipo Visitante")
    var equipo_visitante = readLine()!!.toString()
    println("Ingrese los goles locales")
    var goles_local = readLine()!!.toInt()
    println("Ingrese los goles visitantes")
    var goles_visitante = readLine()!!.toInt()
    var partido = Partido(equipo_local, equipo_visitante, goles_local, goles_visitante)
    println(partido.valido(liga))
    if(partido.valido(liga)){
        liga.forEach(){
            if (it.nombre == partido.equipo_local || it.nombre == partido.equipo_visitante){
                it.actualizar(partido)
            } } }
    println(liga[1])
//Ejercicio 6
    println("Introduzca en numero de ventaja")
    var ventaja = readLine()!!.toInt()
    liga.forEach(){
        if(it.goles_mar - it.goles_enc>ventaja)
            println(it)
    }
}