package com.example.variasactividades01

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Segunda : AppCompatActivity() {
    lateinit var etValor : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etValor = findViewById<EditText>(R.id.etValor)

        //Vamos a leer el valor que se le pasa
        val b : Bundle? = intent.extras
        val cadena : String = b!!.getString("titulo","error titulo")

        etValor.setText(cadena);
    }
    fun salir (obj: View?){
        finish()
    }
}