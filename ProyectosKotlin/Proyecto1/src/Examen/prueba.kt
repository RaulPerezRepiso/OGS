package Examen

fun main(args: Array<String>){

    // Clase Planta
    // a)
    var planta0 = Planta("Esta planta es un Bonsai", 0, 0.0);
    println(planta0);

    //b
    var planta = Planta("Esta planta es un Bonsai", 2, 0.0);
    planta.agregarHumedad(15.0)
    println("Agregando Humedad: "+planta);

    println("La suma de humedad con plus "+ planta.plus(15.0));

    //c
    println("La suma de humedad con plus DoubleArray: "+ planta.plus(doubleArrayOf(20.0, 22.5, 24.0)));

    //d
    planta += 12.0
    planta += 25.0
    planta += 17.0

    println("La media de humedades es: " + planta.media())

    // Clase Planta2
    //e)
    val planta2 = Planta2("Planta2", arrayListOf(12.0, 25.0, 17.0, 10.0))
    println(planta2.cadenaHumedades());
    println(planta2.cadenaHumedadesMayorQue(12.5));

    //f)
    println(planta2.media(arrayListOf(12.0, 25.0, 17.0, 10.0)));

    //g)
    planta2.plus(15.9)
    println(planta2.cadenaHumedades());

    //h)
    val planta3 = Planta2("Planta3", arrayListOf(11.0, 21.0, 13.0, 18.0))
    planta2.plus(planta3)
    println(planta2.cadenaHumedades());

    //i)
    // i) Añadir con ArrayList
    val lista = arrayListOf(Pair(2, 50.0), Pair(3, 60.0))
    planta2.añadirArrayList(lista)

    println("Planta final: $planta2")

   }