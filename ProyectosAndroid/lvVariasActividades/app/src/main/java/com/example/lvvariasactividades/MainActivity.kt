package com.example.lvvariasactividades

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adb = Adb(this, "alumnos1", null, 1)
        val db : SQLiteDatabase
        db = adb.writableDatabase
        val cursor : Cursor

        cursor = db.rawQuery("select _id, nombre, direccion from alumnos",
            null)
        val lvAlumnos = findViewById<ListView>(R.id.lvAlumnos)
        lvAlumnos.adapter = AdapterAlumnDB(this, cursor)

        lvAlumnos.setOnItemClickListener({ adapterView, view, pos : Int, l ->
            val i = Intent(this, MostrarNotas::class.java)
            i.putExtra("id_alumno", cursor.getInt(0))
            startActivity(i)

        })
    }
}