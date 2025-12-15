package Examen2023.Cuenta

class PlazoFijo(nombre: String, monto: Double, var imposicion: Int, var interes: Double): Cuenta(nombre, monto){

}

var pf = PlazoFijo("Raúl", 125.5, 12, 5.0);
