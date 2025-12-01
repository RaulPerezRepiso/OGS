package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var etOperando1 : EditText
    lateinit var etOperando2 : EditText
    lateinit var etResultado : EditText


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etOperando1 = findViewById<EditText>(R.id.etOperando1)
        etOperando2 = findViewById<EditText>(R.id.etOperando2)
        etResultado =findViewById<EditText>(R.id.etResultado)

        // objeto ClickListener con funión Lambda
        findViewById<Button>(R.id.bSumar).setOnClickListener { it : View ->
            var operando1 = etOperando1.text.toString().toDouble()
            var operando2 = etOperando2.text.toString().toDouble()
            var resultado : Double

            resultado = operando1 + operando2

            etResultado.setText( resultado.toString()) }

        // objeto ClickListener engachado a función del sistema
        findViewById<Button>(R.id.bRestar).setOnClickListener(::operar)

        // objeto ClickListener con funión Lambda que llama a una función del sistema
        findViewById<Button>(R.id.bMultiplicar).setOnClickListener ({ it : View -> operar(it) })

        // // objeto ClickListener mediante un objeto que simula una Clase Anonima

        var objeto  = object : View.OnClickListener  {
            override fun onClick(p0: View?) {
                var operando1 = etOperando1.text.toString().toDouble()
                var operando2 = etOperando2.text.toString().toDouble()
                var resultado : Double

                resultado = operando1 / operando2

                etResultado.setText( resultado.toString())
            }
        }
        findViewById<Button>(R.id.bDividir).setOnClickListener (objeto)
    }

    fun operar (obj : View) {
        var operando1 = etOperando1.text.toString().toDouble()
        var operando2 = etOperando2.text.toString().toDouble()
        var resultado : Double
        when (obj.id) {
            R.id.bSumar -> resultado = operando1 + operando2
            R.id.bRestar -> resultado = operando1 - operando2
            R.id.bMultiplicar -> resultado = operando1 * operando2
            R.id.bDividir -> resultado = operando1 / operando2
            else -> resultado = 0.0

        }


        etResultado.setText( resultado.toString())
    }

}