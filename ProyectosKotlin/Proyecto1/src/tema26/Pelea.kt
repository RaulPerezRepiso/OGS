package tema26

class Pelea (val boxeador1: Boxeador, val boxeador2: Boxeador) {
    fun darGolpe(b1:Int){
        if(b1 == 1){
            boxeador1.dados++
            boxeador2.recibidos++
        }else{
            boxeador2.dados++
            boxeador1.recibidos++
        }
    }

    fun jugar(numeroGolpes :Int){
        var pegador: Int
        for(i in 1..numeroGolpes){
            println("Quien pega 1 o 2")
            do
            pegador = readln()!!.toInt()
            while (pegador==1 || pegador == 2)
            this.darGolpe(pegador)

        }
    }
}