package com.example.radiocheck

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val alumno = Alumno("Antonio", false, true, 'H', 'D')

    lateinit var  etNombre : EditText
    lateinit var  cbBecario : CheckBox
    lateinit var  cbRepetidor : CheckBox

    lateinit var  rbFemenino : RadioButton
    lateinit var  rbMasculino : RadioButton
    lateinit var  rbOtros : RadioButton

    lateinit var  rbMoreno : RadioButton
    lateinit var  rbRubio : RadioButton
    lateinit var  rbDesconocido : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etNombre  = findViewById<EditText>(R.id.etNombre)

        cbBecario = findViewById<CheckBox>(R.id.cbBecario)
        cbRepetidor = findViewById<CheckBox>(R.id.cbRepetidor)

        rbFemenino = findViewById<RadioButton>(R.id.rbFemenino)
        rbMasculino = findViewById<RadioButton>(R.id.rbMasculino)
        rbOtros = findViewById<RadioButton>(R.id.rbOtros)

        rbMoreno = findViewById<RadioButton>(R.id.rbMoreno)
        rbRubio = findViewById<RadioButton>(R.id.rbRubio)
        rbDesconocido = findViewById<RadioButton>(R.id.rbDesconocido)
    }

    fun cargar (obj : View) {

    }

    fun guardar (obj : View) {

    }
}