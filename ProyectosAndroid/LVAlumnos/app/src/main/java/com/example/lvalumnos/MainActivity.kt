package com.example.lvalumnos

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
        // cargo el arrayList con los datos de la tabla
        cargar()
        // engancho el ListView
        lvAlumnos = findViewById<ListView>(R.id.lvAlumnos)

        // le asigno el adapter manual
        lvAlumnos.adapter = AdapterAlumno( this, alumnos)

        // hacer algo cuando pulso un elemento
        lvAlumnos.setOnItemClickListener({ adapterView, view, pos : Int, l ->

            Toast.makeText(applicationContext, "Alumnos: " + alumnos[pos].nombre, Toast.LENGTH_LONG ).show()
            ++alumnos[pos]._id
            (lvAlumnos.adapter as AdapterAlumno).notifyDataSetChanged()
        })

        // Listview desde cursor
        val adb = Adb(this, "alumnos1", null, 1)
        val db : SQLiteDatabase
        db = adb.writableDatabase
        val cursor : Cursor

        cursor = db.rawQuery("select _id, nombre, direccion from alumnos",
            null)
        val lvAlumnos2 = findViewById<ListView>(R.id.lvAlumnos2)
        lvAlumnos2.adapter = AdapterAlumnDB(this, cursor)

        lvAlumnos2.setOnItemClickListener({ adapterView, view, pos : Int, l ->
            cursor.moveToPosition(pos)
            Toast.makeText(applicationContext, "De cursor Alumnos: " + cursor.getString(1), Toast.LENGTH_LONG ).show()

        })
    }

    fun  cargar() {
        val adb = Adb(this, "alumnos1", null, 1)
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

        }


        cursor.close()
        db.close()
    }
}