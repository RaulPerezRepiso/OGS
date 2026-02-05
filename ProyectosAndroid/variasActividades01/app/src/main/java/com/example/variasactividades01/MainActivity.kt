package com.example.variasactividades01

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var etValor : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etValor = findViewById<EditText>(R.id.etValor)

    }

    fun primera (obj : View?) {

        val i = Intent(this, Primera::class.java)
        val cadena = etValor.text.toString()
        i.putExtra("valor", cadena)
        startActivity(i)
    }

    fun segunda (obj : View?) {

        val i = Intent(this, Segunda::class.java)
        val cadena = etValor.text.toString()
        i.putExtra("valor", cadena)
        startActivity(i)
    }


}