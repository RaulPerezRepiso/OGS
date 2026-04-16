package com.example.r1_examen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class JuegoAdapter(val ctx: Context, val lista: ArrayList<Juego>) : BaseAdapter() {

    override fun getCount() = lista.size
    override fun getItem(p: Int) = lista[p]
    override fun getItemId(p: Int) = lista[p].id_juego.toLong()

    override fun getView(p: Int, v: View?, parent: ViewGroup?): View {
        val view = v ?: LayoutInflater.from(ctx).inflate(R.layout.item_juego, parent, false)

        val j = lista[p]

        view.findViewById<TextView>(R.id.tvTitulo).text = j.titulo
        view.findViewById<TextView>(R.id.tvId).text = "Id: ${j.id_juego}"
        view.findViewById<TextView>(R.id.tvPrecio).text = "${j.precio} €"

        return view
    }
}
