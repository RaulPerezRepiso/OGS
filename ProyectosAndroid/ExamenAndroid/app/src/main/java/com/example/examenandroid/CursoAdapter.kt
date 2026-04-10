package com.example.examenandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CursoAdapter(val context: Context, val lista: List<Curso>): BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View?
    {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.dos, parent, false)
        val tvNombre = view.findViewById<TextView>(R.id.etNombre)
        val tvPrecio = view.findViewById<TextView>(R.id.etPrecio)
        val curso = lista[position]

        tvNombre.text = curso.nombre
        tvPrecio.text = "${curso.precio} €"
        return view
    }
}