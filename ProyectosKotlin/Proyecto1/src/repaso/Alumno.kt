package repaso

/* el alumno tiene nombre
   curso y notas.
   Las notas son entero que vamos a guardar en un colección
   vamos a usar para coleccion la clase ArrayList<Double>
 */

/* construir la clase con los tres parametros
   si no se pone notas se crea una nota sin vacia
 */

/*
    metodo que devuelve el numero de notas
    metodo que devuelve la media
    numero de notas aprobas
    numero de notas suspendas
    quitar todas las notas de un valor que se pasa por defecto
 */

/* metodo que añade una nota al alumno */
data class Alumno (var nombre:String, var curso:String, var notas: ArrayList<Double> = ArrayList()){

    fun numeroNotas() = notas.size
    fun añadirNota (nota : Double) = notas.add(nota)

    fun mediaNotas1() : Double {
        var sumatorio = 0.0
        for (nota in notas) {
            sumatorio += nota
        }
        return sumatorio / notas.size
    }
    fun mediaNotas2() = notas.average()
    fun mediaNotas3() = notas.sum()/notas.size

    fun numeroAprobadas1() : Int {
        var numero = 0
        for (nota in notas) {
            if (nota >=5)
                numero++
        }
        return numero
    }
    fun numeroAprobadas2() = notas.filter{it >= 5}.size
    fun numeroSuspensas() = notas.filter({it: Double -> it < 5}).size
    fun imprimirNotas (): String {
        var result = ""
        for (nota in notas) {
            result += "%.2f".format(nota) + "  "
        }
        return result
    }
    fun quitarNota (nota : Double) {
        notas.remove(nota)
    }

    fun quitarNota2 (nota : Double) {
        notas = (notas.filter { it != nota }) as ArrayList<Double>
    }
}