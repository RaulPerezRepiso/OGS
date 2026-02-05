package com.example.basedatosbase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class Adb(context: Context?, name: String?, factory: CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table alumnos (_id int primary key, " +
                "nombre  text, direccion text)")

        db.execSQL("insert into alumnos values ('1', 'alumno1', 'calle1');")
        db.execSQL("insert into alumnos values ('2', 'alumno2', 'calle2');")
        db.execSQL("insert into alumnos values ('3', 'alumno3', 'calle3');")
        db.execSQL("insert into alumnos values ('4', 'alumno4', 'calle4');")


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}