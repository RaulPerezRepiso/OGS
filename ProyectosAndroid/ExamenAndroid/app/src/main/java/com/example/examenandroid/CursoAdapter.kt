
package com.example.examenandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CursoAdapter(private val ctx: Context, private val lista: ArrayList<Curso>) : BaseAdapter() {

    override fun getCount() = lista.size
    override fun getItem(position: Int) = lista[position]
    override fun getItemId(position: Int) = lista[position].id_curso.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(ctx).inflate(R.layout.item_curso, parent, false)

        val curso = lista[position]

        view.findViewById<TextView>(R.id.tvTitulo).text = "Mi Curso"
        view.findViewById<TextView>(R.id.tvId).text = "Id:${curso.id_curso}"
        view.findViewById<TextView>(R.id.tvNombre).text = curso.nombre
        view.findViewById<TextView>(R.id.tvPrecio).text = curso.precio.toString()

        return view
    }
}
