package com.example.variasactividadescondevolucionvalores

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var etNombre : EditText
    lateinit var etCurso : EditText
    lateinit var etEdad : EditText
    lateinit var launcherPrimera : ActivityResultLauncher<Intent>
    lateinit var SP: SharedPreferences

    val gson = Gson()

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

        // recuperacion de los datos
        launcherPrimera = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()

        ) {
            if (it.resultCode == 1 && it.data != null) {
                // valores sueltos
                /* val nombre : String? = it.data?.getStringExtra("nombre")
                val edad : Int? = it.data?.getIntExtra("edad", 0)
                val curso : String? = it.data?.getStringExtra("curso") */

                // mediante un objeto.
                val alumno : Alumno = it.data?.getSerializableExtra("alumno") as Alumno
                etNombre.setText(alumno.nombre)
                etCurso.setText(alumno.curso)
                etEdad.setText(alumno.edad.toString())
            }
            }

        // recuperacion valores
        SP = this.getSharedPreferences("fichero", Context.MODE_PRIVATE)
        leer(null)


    }

    fun llamar (obj : View?) {
        var intent = Intent(this, Primera::class.java)

        // envío por partes
        /*intent.putExtra("nombre", etNombre.text.toString())
        intent.putExtra("curso", etCurso.text.toString())
        intent.putExtra("edad", etEdad.text.toString().toInt()) */

        // envío en un único objeto
        intent.putExtra("alumno", Alumno(etNombre.text.toString(),
            etCurso.text.toString(),
            etEdad.text.toString().toInt() ))
        launcherPrimera.launch(intent )
    }

    fun escribir (obj :View?) {
        val nombre = etNombre.text.toString()
        val curso = etCurso.text.toString()
        val edad = etEdad.text.toString().toInt()
        val editor = SP.edit()
        editor.putString("nombre", nombre)
        editor.putString("curso", curso)
        editor.putInt("edad", edad)
        editor.commit()
    }

    fun leer (obj :View?) {
        if(! SP.contains("nombre"))
            Toast.makeText(this, "No se ha guardado nombre", Toast.LENGTH_LONG).show()
        val nombre = SP.getString("nombre", "-----")
        val curso = SP.getString("curso","-----")
        val edad = SP.getInt("edad",0)

        etNombre.setText(nombre)
        etCurso.setText(curso)
        etEdad.setText(edad.toString())
    }

}