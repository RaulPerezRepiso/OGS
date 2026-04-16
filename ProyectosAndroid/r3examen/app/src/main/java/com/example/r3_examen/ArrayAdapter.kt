package com.example.r3_examen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ArrayAdapter(val ctx: Context, val lista: List<String>) : BaseAdapter() {

    override fun getCount() = lista.size
    override fun getItem(p: Int) = lista[p]
    override fun getItemId(p: Int) = p.toLong()

    override fun getView(p: Int, v: View?, parent: ViewGroup?): View {
        val view = v ?: LayoutInflater.from(ctx)
            .inflate(android.R.layout.simple_spinner_item, parent, false)

        val txt = view.findViewById<TextView>(android.R.id.text1)
        txt.text = lista[p]

        return view
    }
}
