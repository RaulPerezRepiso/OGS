package com.example.examenandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import android.database.sqlite.SQLiteDatabase

class MainActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var listaCursos: ArrayList<Curso>
    lateinit var lvCursos: ListView
    lateinit var etInscritos: EditText  // donde se muestran los inscritos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val abd = ABD(this)
        db = abd.readableDatabase

        lvCursos = findViewById(R.id.lvCursos)
        etInscritos = findViewById(R.id.etInscritos)

        cargarCursos()
        configurarListView()
    }

    private fun cargarCursos() {
        listaCursos = ArrayList()
        val cursor = db.rawQuery("SELECT * FROM cursos", null)

        while (cursor.moveToNext()) {
            listaCursos.add(
                Curso(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2)
                )
            )
        }
        cursor.close()

        lvCursos.adapter = CursoAdapter(this, listaCursos)
    }

    private fun configurarListVigit add .ew() {
        lvCursos.setOnItemClickListener { _, _, position, _ ->
            val curso = listaCursos[position]

            // a) Cargar en el EditText todos los inscritos del curso
            mostrarInscritos(curso.id_curso)

            // b) Lanzar segunda actividad con id_curso
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("id_curso", curso.id_curso)
            startActivity(intent)
        }
    }

    private fun mostrarInscritos(idCurso: Int) {
        val cursor = db.rawQuery(
            "SELECT * FROM inscritos WHERE id_curso = ?",
            arrayOf(idCurso.toString())
        )

        val sb = StringBuilder()
        while (cursor.moveToNext()) {
            val idInscrito = cursor.getInt(0)
            val idCurso = cursor.getInt(1)
            val nombre = cursor.getString(2)
            val precio = cursor.getDouble(3)

            sb.append("$idInscrito-$idCurso-$nombre-$precio\n")
        }
        cursor.close()

        etInscritos.setText(sb.toString())
    }
}
