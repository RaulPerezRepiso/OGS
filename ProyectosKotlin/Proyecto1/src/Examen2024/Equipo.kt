package Examen2024

//Ejercicio 1
data class Equipo (var nombre:String, var par_local:Int = 0,
                   var par_vis: Int = 0, var goles_mar: Int= 0, var goles_enc: Int= 0){
    //Ejercicio 3
    fun actualizar(partido :Partido){
        if (partido.equipo_local == this.nombre){
            par_local++
            if(partido.goles_local>0){
                goles_mar += partido.goles_local
            }
            if(partido.goles_vis>0){
                goles_enc += partido.goles_vis
            }
        }
        else{
            par_vis++
            goles_mar += partido.goles_vis
            goles_enc += partido.goles_local
        }
    }
    //Ejercicio 5
    fun actualizarEstado(vararg resultados: ResultadoEquipo){
        for(resultado in resultados){
            this.goles_mar += resultado.goles_marcados
            this.goles_enc += resultado.goles_encajados
        }
    }
}