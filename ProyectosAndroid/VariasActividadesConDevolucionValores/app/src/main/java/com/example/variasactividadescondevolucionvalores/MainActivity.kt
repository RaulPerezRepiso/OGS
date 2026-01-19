package com.example.variasactividadescondevolucionvalores

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

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

        //Recuperación de los datos
        launcherPrimera = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult())
            {

            }

    }

    fun llamar (obj: View? ){
        var intent = Intent(this, Primera::class.java)
        intent.putExtra("nombre", etNombre.text.toString())
        intent.putExtra("curso", etCurso.text.toString())
        intent.putExtra("edad", etEdad.text.toString().toInt())
        launcherPrimera.launch(intent )

    }
}