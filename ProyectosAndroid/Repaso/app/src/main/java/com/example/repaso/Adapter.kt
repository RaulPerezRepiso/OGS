package com.example.repaso

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter(val context: Context, val Juegos: List<Videojuego>): BaseAdapter() {

    override fun getCount(): Int {
        return Juegos.size
    }

    override fun getItem(position: Int): Any {
        return Juegos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val fila = LayoutInflater.from(context).inflate(R.layout.a, parent, false)

        val id1: TextView = fila.findViewById(R.id.id1)
        val id2: TextView = fila.findViewById(R.id.id2)
        val id3: TextView = fila.findViewById(R.id.id3)

        id1.text = Juegos[position].titulo
        id2.text = Juegos[position].plataforma
        id3.text = Juegos[position].puntacion.toString()

        return fila
    }

}