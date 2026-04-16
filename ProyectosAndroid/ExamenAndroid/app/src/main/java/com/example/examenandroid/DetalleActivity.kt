package com.example.examenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.database.sqlite.SQLiteDatabase

class DetalleActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var etIdCurso: EditText
    lateinit var etNombre: EditText
    lateinit var etPrecio: EditText
    lateinit var btnInsertar: Button
    lateinit var btnSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val abd = ABD(this)
        db = abd.writableDatabase

        etIdCurso = findViewById(R.id.etIdCurso)
        etNombre = findViewById(R.id.etNombre)
        etPrecio = findViewById(R.id.etPrecio)
        btnInsertar = findViewById(R.id.btnInsertar)
        btnSalir = findViewById(R.id.btnSalir)

        val idCurso = intent.getIntExtra("id_curso", -1)
        etIdCurso.setText(idCurso.toString())
        etIdCurso.isEnabled = false

        btnInsertar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val precio = etPrecio.text.toString().toDoubleOrNull() ?: 0.0

            db.execSQL(
                "INSERT INTO inscritos (id_curso, nombre, precio) VALUES (?, ?, ?)",
                arrayOf(idCurso, nombre, precio)
            )

            finish()
        }

        btnSalir.setOnClickListener {
            finish()
        }
    }
}