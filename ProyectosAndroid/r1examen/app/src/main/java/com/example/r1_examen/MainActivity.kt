package com.example.r1_examen

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var lista: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bd = BD(this)
        db = bd.readableDatabase

        cargarDatos()

        val lv = findViewById<ListView>(R.id.lvProductos)
        lv.adapter = ProductoAdapter(this, lista)

        lv.setOnItemClickListener { _, _, pos, _ ->
            val p = lista[pos]
            Toast.makeText(this, "ID: ${p.id} - ${p.nombre}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarDatos() {
        lista = ArrayList()

        val cursor = db.rawQuery("SELECT * FROM productos", null)

        while (cursor.moveToNext()) {
            lista.add(
                Producto(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2)
                )
            )
        }

        cursor.close()
    }
}
