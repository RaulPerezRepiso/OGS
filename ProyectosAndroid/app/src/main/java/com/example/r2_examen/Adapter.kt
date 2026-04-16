package com.example.r2_examen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter(val ctx: Context, val lista: List<Producto>) : BaseAdapter() {

    override fun getCount() = lista.size
    override fun getItem(p: Int) = lista[p]
    override fun getItemId(p: Int) = lista[p].id.toLong()

    override fun getView(p: Int, v: View?, parent: ViewGroup?): View {
        val view = v ?: LayoutInflater.from(ctx).inflate(R.layout.item_producto, parent, false)

        val prod = lista[p]
        view.findViewById<TextView>(R.id.tvNombre).text = prod.nombre
        view.findViewById<TextView>(R.id.tvPrecio).text = "${prod.precio} €"

        return view
    }
}
