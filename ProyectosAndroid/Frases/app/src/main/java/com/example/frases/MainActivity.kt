package com.example.frases

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var etFrases : EditText
    lateinit var etFrase : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        etFrases = findViewById<EditText>(R.id.etFrases)
        etFrase = findViewById<EditText>(R.id.etFrase)

    }

    fun añadir (obj : View) {
        var cadena = ""
        cadena = etFrases.text.toString()
        cadena += "\n" + etFrase.text.toString()
        etFrases.setText(cadena)

    }
}