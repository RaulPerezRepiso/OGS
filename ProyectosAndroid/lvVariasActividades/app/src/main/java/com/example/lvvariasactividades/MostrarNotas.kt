package com.example.lvvariasactividades

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MostrarNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mostrar_notas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val b : Bundle? = intent.extras
        val id_alumno : Int = b!!.getInt("id_alumno",0)
        Toast.makeText(this, "id:alumno $id_alumno", Toast.LENGTH_LONG).show()

        val adb = Adb(this, "alumnos1", null, 1)
        val db : SQLiteDatabase
        db = adb.writableDatabase
        val cursor : Cursor

        cursor = db.rawQuery("select _id, id_alumno, descripcion, notas from notas where id_alumno = ?",
            arrayOf(id_alumno.toString()))
        val lvNotas = findViewById<ListView>(R.id.lvNotas)
        lvNotas.adapter = AdapterNotasDB(this, cursor)
    }

    fun salir (obj : View?)
    {
        finish()
    }
}