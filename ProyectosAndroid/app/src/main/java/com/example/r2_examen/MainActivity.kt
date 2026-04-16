package com.example.r2_examen

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

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
        lv.adapter = Adapter(this, lista)

        lv.setOnItemClickListener { _, _, pos, _ ->
            val p = lista[pos]

            val intent = Intent(this, DetalleActivity::class.java)

            intent.putExtra("id", p.id)
            intent.putExtra("nombre", p.nombre)
            intent.putExtra("precio", p.precio)
            intent.putExtra("plataforma", p.plataforma)
            intent.putExtra("puntuacion", p.puntuacion)

            startActivity(intent)
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
                    cursor.getDouble(2),
                    cursor.getString(3),
                    cursor.getDouble(4)
                )
            )
        }

        cursor.close()
    }
}
