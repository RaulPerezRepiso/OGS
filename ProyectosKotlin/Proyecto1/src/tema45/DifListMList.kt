package tema45

/*
diferencia entre objetos de la clase List y la clase MutablList
*/

fun main(args: Array<String>) {
    var diasSemana : List<String> = listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")
    var diasSemanaM : MutableList<String> = MutableList<String>  (7, {diasSemana.get(it)})


    // prueba de carga diasSemanaM

    diasSemanaM.add(7, "octavo")
    diasSemanaM.add(5, "en medio")
    diasSemanaM.forEach { print("$it   ") }
    println()
    diasSemanaM.removeAt(0)
    diasSemanaM.forEach { print("$it   ") }

    var disSemanaA : Array<String> = Array<String>(7, {diasSemana.get(it)})

    disSemanaA[0]="Maldito lunes"
    println()
    disSemanaA.forEach { print("$it   ") }
}
