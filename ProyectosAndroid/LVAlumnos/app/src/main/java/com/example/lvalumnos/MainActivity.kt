package com.example.lvalumnos

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var alumnos = ArrayList<Alumno>()
    lateinit var lvAlumnos : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargar()
        lvAlumnos = findViewById<ListView>(R.id.lvAlumnos)
        lvAlumnos.adapter = AdapterAlumno(this, alumnos)
    }
    fun  cargar() {
        val adb = Adb(this, "alumnos", null, 1)
        val db : SQLiteDatabase
        db = adb.writableDatabase
        val cursor : Cursor

        cursor = db.rawQuery("select _id, nombre, direccion from alumnos",
            null)
        while (cursor.moveToNext()){
            alumnos.add(Alumno( cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
            ))
            alumnos.add(Alumno( cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
            ))
            alumnos.add(Alumno( cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
            ))
            alumnos.add(Alumno( cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
            ))
        }


        cursor.close()
        db.close()
    }
}