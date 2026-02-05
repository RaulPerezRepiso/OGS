package com.example.variasactividadescondevolucionvalores

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Primera : AppCompatActivity() {
    lateinit var etNombre : EditText
    lateinit var etCurso : EditText
    lateinit var etEdad : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_primera)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etNombre = findViewById<EditText>(R.id.etNombre)
        etCurso = findViewById<EditText>(R.id.etCurso)
        etEdad = findViewById<EditText>(R.id.etEdad)

        // objeto bundle
        val b : Bundle? = intent.extras
        /*
        val nombre : String = b!!.getString("nombre","error titulo")
        val curso : String = b!!.getString("curso","error titulo")
        val edad : Int = b!!.getInt("edad", 0)
        */

        val alumno : Alumno = b!!.getSerializable("alumno") as Alumno

        etNombre.setText(alumno.nombre)
        etCurso.setText(alumno.curso)
        etEdad.setText(alumno.edad.toString())

    }

    fun salir (obj : View?) {
        // valores sueltos
        /* intent.putExtra("nombre", etNombre.text.toString())
        intent.putExtra("curso", etCurso.text.toString())
        intent.putExtra("edad", etEdad.text.toString().toInt())
        */
        // objeto
        intent.putExtra("alumno", Alumno(etNombre.text.toString(),
            etCurso.text.toString(),
            etEdad.text.toString().toInt()))
        setResult(1, intent)
        finish()
    }
}