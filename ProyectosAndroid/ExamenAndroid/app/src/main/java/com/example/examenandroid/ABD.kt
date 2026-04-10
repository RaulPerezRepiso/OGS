package com.example.examenandroid

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

import android.database.sqlite.SQLiteOpenHelper

class ABD(context: Context?, name: String?, factory: CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table cursos (id_curso integer primary key autoincrement, " +
                "nombre  string, " +
                "precio double)")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso1', 110);")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso2', 1200);")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso3', 130);")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso4', 140);")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso5', 150);")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso6', 160);")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso7', 170);")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso8', 180);")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso9', 190);")
        db.execSQL ("insert into cursos (nombre, precio) values ('Curso10', 200);")



        db.execSQL("create table inscritos (id_inscrito integer primary key autoincrement, " +
                "id_curso  integer, nombre string, precio double)")

        db.execSQL("insert into inscritos(id_curso, nombre, precio) " +
                "values (1,'Juan', 100);")

        db.execSQL("insert into inscritos(id_curso, nombre, precio) " +
                "values (2,'Juan', 100);")

        db.execSQL("insert into inscritos(id_curso, nombre, precio) " +
                "values (3,'Antonio', 100);")

        db.execSQL("insert into inscritos(id_curso, nombre, precio) " +
                "values (3,'Manuel', 100);")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}
