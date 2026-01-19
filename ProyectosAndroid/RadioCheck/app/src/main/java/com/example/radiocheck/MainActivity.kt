package com.example.radiocheck

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    val alumno = Alumno("Antonio", "2DAWA", true,
        false, 'M', 'D')

    lateinit var  etNombre : EditText
    lateinit var  cbBecario : CheckBox
    lateinit var  cbRepetidor : CheckBox

    lateinit var  rbFemenino : RadioButton
    lateinit var  rbMasculino : RadioButton
    lateinit var  rbOtros : RadioButton

    lateinit var  rbMoreno : RadioButton
    lateinit var  rbRubio : RadioButton
    lateinit var  rbDesconocido : RadioButton

    lateinit var sCurso : Spinner

    val opciones = arrayOf<String>("1SMRA", "1SMRB", "2SMRA", "2SMRB", "1DAWA", "2DAWA")

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


        // Spinner sCurso

        sCurso =  findViewById<Spinner>(R.id.sCurso);



        sCurso.adapter = ArrayAdapter<String?>(
            applicationContext,
            android.R.layout.simple_spinner_item,
            opciones
        )



        cargar(null)
    }

    fun cargar (obj : View?) {

        etNombre.setText( alumno.nombre)
        cbBecario.setChecked(alumno.becario)
        cbRepetidor.isChecked = alumno.repetidor
        when(alumno.sexo) {
            'M' -> rbMasculino.isChecked = true
            'F' -> rbFemenino.isChecked = true
            'O' -> rbOtros.isChecked = true
            else -> rbOtros.isChecked = true
        }

        when(alumno.colorPelo) {
            'M' -> rbMoreno.isChecked = true
            'R' -> rbRubio.isChecked = true
            'D' -> rbDesconocido.isChecked = true
            else -> rbDesconocido.isChecked = true
        }

        // Spinner


        sCurso.setSelection( opciones.indexOf(alumno.curso))
        }

    fun guardar (obj : View) {
        alumno.nombre = etNombre.text.toString()

        alumno.becario = cbBecario.isChecked
        alumno.repetidor = cbRepetidor.isChecked

        if (rbMasculino.isChecked)
            alumno.sexo = 'M'
        else if (rbFemenino.isChecked)
            alumno.sexo = 'F'
        else
            alumno.sexo = 'O'

        if (rbMoreno.isChecked)
            alumno.colorPelo = 'M'
        else if (rbRubio.isChecked)
            alumno.sexo = 'R'
        else
            alumno.sexo = 'D'
        // guardamos el curso
        alumno.curso = opciones[ sCurso.selectedItemPosition ]

        Toast.makeText(this,opciones[ sCurso.selectedItemPosition ], Toast.LENGTH_LONG ).show()
    }
}