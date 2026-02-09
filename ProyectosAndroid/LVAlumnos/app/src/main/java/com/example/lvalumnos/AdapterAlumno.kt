package com.example.lvalumnos


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AdapterAlumno (context: Context, alumnos: List<Alumno>): BaseAdapter() {
    private val context = context
    private val alumnos = alumnos

    override fun getCount(): Int {
        return alumnos.count()
    }

    override fun getItem(position: Int): Any {
        return alumnos[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?):
            View? {

        val alumnoView = LayoutInflater.from(context).inflate(R.layout.layout_alumnos,
            parent, false)
        if (position % 2 == 0 )
            alumnoView.setBackgroundColor(Color.parseColor("#0066FF"))
        else
            alumnoView.setBackgroundColor(Color.parseColor("#FF6600"))

        val tv_id: TextView = alumnoView.findViewById(R.id.tv_id)
        val tvNombre: TextView = alumnoView.findViewById(R.id.tvNombre)
        val tvDireccion: TextView = alumnoView.findViewById(R.id.tvDireccion)

        // ID
        tv_id.setText(alumnos[position]._id.toString())

        // nombre
        tvNombre.setText( alumnos[position].nombre)

        // direccion
        tvDireccion.setText( alumnos[position].direccion)

        return alumnoView

    }
}
