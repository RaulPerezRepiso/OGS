package com.example.examenandroid
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

import android.database.sqlite.SQLiteOpenHelper

class ABD(context: Context) :
    SQLiteOpenHelper(context, "cursos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE cursos (" +
                    "id_curso INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre STRING, " +
                    "precio DOUBLE)"
        )

        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso1', 110)")
        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso2', 1200)")
        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso3', 130)")
        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso4', 140)")
        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso5', 150)")
        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso6', 160)")
        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso7', 170)")
        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso8', 180)")
        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso9', 190)")
        db.execSQL("INSERT INTO cursos (nombre, precio) VALUES ('Curso10', 200)")

        db.execSQL(
            "CREATE TABLE inscritos (" +
                    "id_inscrito INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "id_curso INTEGER, " +
                    "nombre STRING, " +
                    "precio DOUBLE)"
        )

        db.execSQL("INSERT INTO inscritos (id_curso, nombre, precio) VALUES (1, 'Juan', 100)")
        db.execSQL("INSERT INTO inscritos (id_curso, nombre, precio) VALUES (2, 'Juan', 100)")
        db.execSQL("INSERT INTO inscritos (id_curso, nombre, precio) VALUES (3, 'Antonio', 100)")
        db.execSQL("INSERT INTO inscritos (id_curso, nombre, precio) VALUES (3, 'Manuel', 100)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}
