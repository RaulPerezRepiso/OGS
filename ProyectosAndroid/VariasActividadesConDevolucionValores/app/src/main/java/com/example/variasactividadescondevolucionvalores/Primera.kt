package com.example.variasactividadescondevolucionvalores

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Primera : AppCompatActivity() {
    lateinit var etNombre: EditText
    lateinit var etCurso: EditText
    lateinit var etEdad: EditText

    lateinit var launcherPrimera: ActivityResultLauncher<Intent>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etNombre = findViewById<EditText>(R.id.etNombre)
        etCurso = findViewById<EditText>(R.id.etCurso)
        etEdad = findViewById<EditText>(R.id.etEdad)

        val b : Bundle? = intent.extras
        val nombre : String = b!!.getString("nombre", "error titulo")
        val curso : String = b!!.getString("curso", "error titulo")
        val edad : Int = b!!.getInt("edad", 0)

        etNombre.setText(nombre);
        etCurso.setText(curso);
        etEdad.setText(edad.toString());
    }

    fun salir (obj : View?){
        finish()
    }
}