package com.example.r1_examen

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var lista: ArrayList<Juego>
    lateinit var adaptadorPlataforma: ArrayAdapter<String>

    lateinit var spPlataforma: Spinner
    lateinit var lvJuegos: ListView
    lateinit var txtJugadores: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bd = BD(this)
        db = bd.readableDatabase

        spPlataforma = findViewById(R.id.spPlataforma)
        lvJuegos = findViewById(R.id.lvJuegos)
        txtJugadores = findViewById(R.id.txtJugadores)

        cargarSpinner()
        cargarLista("PS5")
        configurarEventos()
    }

    fun cargarSpinner() {
        val opciones = arrayOf("PS5", "XBOX", "Switch", "PC")

        adaptadorPlataforma = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            opciones
        )

        adaptadorPlataforma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spPlataforma.adapter = adaptadorPlataforma
    }

    fun cargarLista(plataforma: String) {
        lista = ArrayList()

        val cursor = db.rawQuery(
            "SELECT * FROM videojuegos WHERE plataforma = ?",
            arrayOf(plataforma)
        )

        while (cursor.moveToNext()) {
            lista.add(
                Juego(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getDouble(3)
                )
            )
        }
        cursor.close()

        lvJuegos.adapter = JuegoAdapter(this, lista)
    }

    fun configurarEventos() {

        spPlataforma.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                cargarLista(spPlataforma.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        lvJuegos.setOnItemClickListener { _, _, pos, _ ->
            val juego = lista[pos]

            mostrarJugadores(juego.id_juego)

            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("id_juego", juego.id_juego)
            startActivity(intent)
        }
    }

    fun mostrarJugadores(idJuego: Int) {
        val cursor = db.rawQuery(
            "SELECT * FROM jugadores WHERE id_juego = ?",
            arrayOf(idJuego.toString())
        )

        val texto = StringBuilder()

        while (cursor.moveToNext()) {
            texto.append(
                "${cursor.getInt(0)} - ${cursor.getString(2)} - ${cursor.getInt(3)}h\n"
            )
        }

        cursor.close()

        txtJugadores.text = texto.toString()
    }
}
