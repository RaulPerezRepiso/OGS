package com.example.lvvariasactividades

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView

class AdapterNotasDB(context: Context?, cursor: Cursor?) :
    CursorAdapter(context, cursor, 0) {
    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_notas, parent, false)
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    override fun bindView(view: View, context: Context?, cursor: Cursor) {
        // Find fields to populate in inflated template
        val tv_id = view.findViewById<TextView>(R.id.tv_id)
        val tvId_alumno = view.findViewById<TextView>(R.id.tvId_alumno)
        val tvDescripcion = view.findViewById<TextView>(R.id.tvDescripcion)
        val tvNota = view.findViewById<TextView>(R.id.tvNota)




        tv_id.setText(cursor.getInt(0).toString())
        tvId_alumno.setText( cursor.getInt(1).toString())
        tvDescripcion.setText(cursor.getString(2))
        tvNota.setText( cursor.getInt(3).toString())
    }
}
