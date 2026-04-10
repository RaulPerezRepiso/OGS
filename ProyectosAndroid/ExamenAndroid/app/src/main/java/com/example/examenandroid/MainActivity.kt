package com.example.examenandroid

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var listaCursos: ArrayList<Curso>
    lateinit var lvCursos: ListView
    lateinit var etInscritos: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvCursos = findViewById(R.id.lvCursos)
        etInscritos = findViewById(R.id.etInscritos)

        val bd = ABD(this, "cursos.db", null, 1)
        db = bd.readableDatabase

        cargarCursos()
    }

    private fun cargarCursos() {

        val cursor = db.rawQuery("SELECT * FROM cursos", null)
        val datos = ArrayList<Curso>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id_curso"))
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                val precio = cursor.getDouble(cursor.getColumnIndexOrThrow("precio"))

                datos.add(Curso(id, nombre, precio))
            } while (cursor.moveToNext())
        }
        cursor.close()

        val adapter= Adapter(this, datos)
        lvCursos.adapter = adapter
    }


}
