package tema30

enum class Palo { OROS, COPAS, BASTOS, ESPADAS
}

enum class Dia { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
}

enum class Figura   { AS, TRES, SOTA, CABALLO, REY
}

enum class FiguraValor (val peso : Int, var pesoBrisca : Int) {
    AS(11,1),
    TRES(10, 3),
    REY(4, 12),
    CABALLO(3, 11),
    SOTA(2, 10)
}