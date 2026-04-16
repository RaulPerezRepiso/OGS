package com.example.r3_examen

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var lista: ArrayList<Juego>
    var pos = 0

    lateinit var spPlataforma: Spinner
    lateinit var txtId: TextView
    lateinit var txtNombre: TextView
    lateinit var txtAnio: TextView
    lateinit var txtPuntuacion: TextView

    // ⬇⬇⬇ ADAPTADOR DEL SPINNER (IMPORTANTE)
    lateinit var adaptadorPlataforma: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bd = BD(this)
        db = bd.readableDatabase

        spPlataforma = findViewById(R.id.spPlataforma)
        txtId = findViewById(R.id.txtId)
        txtNombre = findViewById(R.id.txtNombre)
        txtAnio = findViewById(R.id.txtAnio)
        txtPuntuacion = findViewById(R.id.txtPuntuacion)

        cargarSpinner()
        cargarLista()
        mostrar(pos)
    }

    fun cargarSpinner() {
        val opciones = arrayOf("PS5", "XBOX", "Switch")

        adaptadorPlataforma = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            opciones
        )

        adaptadorPlataforma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spPlataforma.adapter = adaptadorPlataforma
    }

    fun cargarLista() {
        lista = ArrayList()
        val cursor = db.rawQuery("SELECT * FROM juegos", null)

        while (cursor.moveToNext()) {
            lista.add(
                Juego(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getDouble(4)
                )
            )
        }
        cursor.close()
    }

    fun mostrar(i: Int) {
        val j = lista[i]

        txtId.text = j.id.toString()
        txtNombre.text = j.nombre
        txtAnio.text = j.anio.toString()
        txtPuntuacion.text = j.puntuacion.toString()

        // ⬇⬇⬇ AQUÍ YA NO FALLA NUNCA
        val posSpinner = adaptadorPlataforma.getPosition(j.plataforma)
        spPlataforma.setSelection(posSpinner)
    }

    fun primero(view: View) {
        pos = 0
        mostrar(pos)
    }

    fun ultimo(view: View) {
        pos = lista.size - 1
        mostrar(pos)
    }

    fun siguiente(view: View) {
        pos++
        if (pos >= lista.size) pos = 0
        mostrar(pos)
    }

    fun anterior(view: View) {
        pos--
        if (pos < 0) pos = lista.size - 1
        mostrar(pos)
    }

    fun insertar(view: View) {
        val nombre = txtNombre.text.toString()
        val plataforma = spPlataforma.selectedItem.toString()
        val anio = txtAnio.text.toString().toInt()
        val puntuacion = txtPuntuacion.text.toString().toDouble()

        db.execSQL(
            "INSERT INTO juegos(nombre, plataforma, anio, puntuacion) VALUES (?, ?, ?, ?)",
            arrayOf(nombre, plataforma, anio, puntuacion)
        )

        cargarLista()
        pos = lista.size - 1
        mostrar(pos)
    }

    fun borrar(view: View) {
        val id = txtId.text.toString()

        db.execSQL("DELETE FROM juegos WHERE id = ?", arrayOf(id))

        cargarLista()
        if (lista.isNotEmpty()) {
            pos = 0
            mostrar(pos)
        }
    }
}
