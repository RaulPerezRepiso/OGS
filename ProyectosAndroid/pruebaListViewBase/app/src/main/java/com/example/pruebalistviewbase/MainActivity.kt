package com.example.pruebalistviewbase

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


/*

    Vamos a implementar una especie de contador
    Sale un menu que tiene uno, dos, tres , cuatro, cinco , seis, siete, ocho
    y cada vez que pulse a una opción del menú suma el valor a un editText
 */
class MainActivity : AppCompatActivity() {



    lateinit var lvNombres : ListView
    lateinit var etNombre : EditText
    val listaNombres : ArrayList<String> = arrayListOf("Juan", "Felipe", "Soraya", "Diana",
                                                       "Manuel", "Macarena", "Lucía", "Ava")

    var posicion : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lvNombres = findViewById<ListView>(R.id.lvNombres)
        lvNombres.adapter = ArrayAdapter<String> (applicationContext,
                                         android.R.layout.simple_list_item_1,
                                         listaNombres)

        etNombre = findViewById<EditText>(R.id.etNombre)


        /* hecho con una función Lambda */

       /* lvNombres.setOnItemClickListener { adapterView, view, pos : Int , l ->
           etNombre.setText(listaNombres[pos])
        } */

        /* hecho con jun objeto
          que sería un clase anonima en Java
         */
        val objeto  = object :  AdapterView.OnItemClickListener  {
            override fun onItemClick(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                etNombre.setText(listaNombres[p2])
                posicion =  p2
            }

        }
        lvNombres.setOnItemClickListener ( objeto )



    }
    fun cambiar (obj : View) {
        listaNombres[posicion] = etNombre.text.toString()
        /* actualizando con notifyDataSetChange */
        /*
        (lvNombres.adapter as ArrayAdapter<String>).notifyDataSetChanged()
         */

        /* regenera el adapter */
        lvNombres.adapter = ArrayAdapter<String> (applicationContext,
            android.R.layout.simple_list_item_1,
            listaNombres)


    }
}