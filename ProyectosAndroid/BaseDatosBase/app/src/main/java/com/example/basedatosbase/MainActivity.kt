package com.example.basedatosbase

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var db : SQLiteDatabase
    lateinit var cursor : Cursor

    lateinit var et_id : EditText
    lateinit var etNombre : EditText
    lateinit var etDireccion : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adb = Adb(this, "alumnos", null, 1)
        db = adb.writableDatabase

       // enganchar los et

        et_id = findViewById<EditText>(R.id.et_id)
        etNombre= findViewById<EditText>(R.id.etNombre)
        etDireccion =findViewById<EditText>(R.id.etDireccion)



        // los resulSet en Android se llaman cursores
        // cursor con select
        cursor = db.rawQuery("select _id, nombre, direccion from alumnos",
                             null)


        if (cursor.isFirst)
            println("He entradoal principio")
        siguiente(null)
    }

    fun cargar () {
        et_id.setText((cursor.getInt(0)).toString())
        etNombre.setText( cursor.getString(1))
        etDireccion.setText(cursor.getString(2))
    }

    fun siguiente (obj : View?) {
        if (!cursor.moveToNext())
            cursor.moveToFirst()
        cargar()
    }
    fun anterior (obj : View?) {
        if (!cursor.moveToPrevious())
            cursor.moveToLast()
        cargar()
    }

    fun primero (obj : View?) {

        cursor.moveToFirst()
        cargar()
    }

    fun ultimo (obj : View?) {
        cursor.moveToLast()
        cargar()
    }

    fun insertar (obj : View?) {
        val id = et_id.text.toString().toInt()
        val nombre = etNombre.text.toString()
        val direccion = etDireccion.text.toString()


        val registro = ContentValues()

        registro.put("_id", id)
        registro.put("nombre", nombre)
        registro.put("direccion", direccion)
        db.insert("alumnos", null, registro)

        cursor.requery()
        ultimo(null)

    }

    fun borrar (obj : View?) {
        var codigo : Int = et_id.text.toString().toInt()
        var registrosBorrados = db.delete("alumnos", "_id = ?", arrayOf(codigo.toString()))
        Toast.makeText(this, "Se han borrado $registrosBorrados", Toast.LENGTH_LONG).show()

        cursor.requery()


        siguiente(null)

    }

    fun modificar (obj : View?) {
        val id = et_id.text.toString().toInt()
        val nombre = etNombre.text.toString()
        val direccion = etDireccion.text.toString()

        val posicion = cursor.position
        val registro = ContentValues()
        // registro con el set
        registro.put("nombre", nombre)
        registro.put("direccion", direccion)

        // modificación con update tabla , registro, whereClause
        db.update("alumnos", registro, "_id = ?", arrayOf(id.toString()) )

        cursor.requery()
        cursor.move(posicion)

    }

    // vamos a poner un numero en el _id y salta a esa posición
    fun saltar (obj : View?) {
        var posicion : Int = et_id.text.toString().toInt()
        if(cursor.moveToPosition(posicion - 1 ))
            cargar()
        else {
            etNombre.setText( "--------")
            etDireccion.setText("--------")
        }
    }

    fun saltarPorId (obj : View?) {
        var id : Int = et_id.text.toString().toInt()
        cursor.moveToFirst()
        etNombre.setText( "--------")
        etDireccion.setText("--------")

        do {
            if (cursor.getInt(0) == id)
            {
                cargar()
                break
            }
        }
        while (cursor.moveToNext())

    }
    fun busqueda (obj : View?) {

        val cursor2 = db.rawQuery(
            "select _id, nombre, direccion from alumnos where _id = ?",
            arrayOf(et_id.text.toString()))
        if (cursor2.moveToNext())
        {
            et_id.setText((cursor2.getInt(0)).toString())
            etNombre.setText( cursor2.getString(1))
            etDireccion.setText(cursor2.getString(2))
        }
        else
        {
            et_id.setText("0")
            etNombre.setText( "--------")
            etDireccion.setText("------------")
        }
        cursor2.close()
    }
}