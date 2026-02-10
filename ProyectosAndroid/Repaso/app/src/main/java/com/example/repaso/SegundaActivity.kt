package com.example.repaso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class SegundaActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dos)

        val titulo = intent.getStringExtra("titulo")
        val plataforma = intent.getStringExtra("plataforma")
        val puntuacion = intent.getStringExtra("puntuacion")


       val titulo1 = findViewById<TextView>(R.id.id21)
       val plataforma1 = findViewById<TextView>(R.id.id22)
       val puntuacion1 = findViewById<TextView>(R.id.id23)

        titulo1.setText(""+titulo)
        plataforma1.setText(""+plataforma)
        puntuacion1.setText(""+puntuacion)

     }
}