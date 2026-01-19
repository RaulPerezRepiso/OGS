package com.example.lvseleccionados

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.String
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var lvSeleccionados : ListView
    lateinit var lvNoSeleccionados : ListView

    val seleccionados : ArrayList<String> = arrayListOf("Juan", "Felipe", "Soraya", "Diana", "María")

    val noSeleccionados : ArrayList<String> = arrayListOf("Alvaro", "Jacinto", "Enrique", "Ana")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lvSeleccionados = findViewById<ListView>(R.id.lvSeleccionados)
        lvSeleccionados.adapter = ArrayAdapter<String> (applicationContext,
            android.R.layout.simple_list_item_1,
            seleccionados)

        lvNoSeleccionados = findViewById<ListView>(R.id.lvNoSeleccionados)
        lvNoSeleccionados.adapter = ArrayAdapter<String> (applicationContext,
            android.R.layout.simple_list_item_1,
            noSeleccionados)

        lvSeleccionados.setOnItemClickListener { adapterView, view, pos : Int , l ->
            noSeleccionados.add(seleccionados[pos])
            seleccionados.removeAt(pos)
            (lvSeleccionados.adapter as ArrayAdapter<String>).notifyDataSetChanged()
            (lvNoSeleccionados.adapter as ArrayAdapter<String>).notifyDataSetChanged()

        }

        lvNoSeleccionados.setOnItemClickListener { adapterView, view, pos : Int , l ->
            seleccionados.add(noSeleccionados[pos])
            noSeleccionados.removeAt(pos)
            (lvSeleccionados.adapter as ArrayAdapter<String>).notifyDataSetChanged()
            (lvNoSeleccionados.adapter as ArrayAdapter<String>).notifyDataSetChanged()

        }
    }

    fun añadir (obj : View?) {
        seleccionados.add( findViewById<EditText>(R.id.etNombre).text.toString()
        )
        (lvSeleccionados.adapter as ArrayAdapter<String>).notifyDataSetChanged()
    }
}