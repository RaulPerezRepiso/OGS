package com.example.r2_examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val id = intent.getIntExtra("id", -1)
        val nombre = intent.getStringExtra("nombre")
        val precio = intent.getDoubleExtra("precio", 0.0)
        val plataforma = intent.getStringExtra("plataforma")
        val puntuacion = intent.getDoubleExtra("puntuacion", 0.0)

        findViewById<TextView>(R.id.txtId).text = id.toString()
        findViewById<TextView>(R.id.txtNombre).text = nombre
        findViewById<TextView>(R.id.txtPrecio).text = precio.toString()
        findViewById<TextView>(R.id.txtPlataforma).text = plataforma
        findViewById<TextView>(R.id.txtPuntuacion).text = puntuacion.toString()
    }
}
