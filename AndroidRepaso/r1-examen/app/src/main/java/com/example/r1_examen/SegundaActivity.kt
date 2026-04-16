package com.example.r1_examen

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var txtIdJuego: EditText
    lateinit var txtNombre: EditText
    lateinit var txtHoras: EditText
    lateinit var btnInsertar: Button
    lateinit var btnVolver: Button
    lateinit var btnSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda_activity)

        val bd = BD(this)
        db = bd.writableDatabase

        txtIdJuego = findViewById(R.id.txtIdJuego)
        txtNombre = findViewById(R.id.txtNombre)
        txtHoras = findViewById(R.id.txtHoras)
        btnInsertar = findViewById(R.id.btnInsertar)
        btnVolver = findViewById(R.id.btnVolver)
        btnSalir = findViewById(R.id.btnSalir)

        val idJuego = intent.getIntExtra("id_juego", -1)
        txtIdJuego.setText(idJuego.toString())

        btnInsertar.setOnClickListener {
            db.execSQL(
                "INSERT INTO jugadores(id_juego, nombre, horas) VALUES (?, ?, ?)",
                arrayOf(
                    txtIdJuego.text.toString(),
                    txtNombre.text.toString(),
                    txtHoras.text.toString().toInt()
                )
            )
            finish()
        }

        btnVolver.setOnClickListener { finish() }

        btnSalir.setOnClickListener { finishAffinity() }
    }
}
