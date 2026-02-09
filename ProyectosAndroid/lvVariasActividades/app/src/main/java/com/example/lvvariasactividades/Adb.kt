package com.example.lvvariasactividades

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlin.collections.count

class Adb(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table alumnos (_id int primary key, " +
                "nombre  text, direccion text)")

        db.execSQL("insert into alumnos values ('1', 'alumno1', 'calle1');")
        db.execSQL("insert into alumnos values ('2', 'alumno2', 'calle2');")
        db.execSQL("insert into alumnos values ('3', 'alumno3', 'calle3');")
        db.execSQL("insert into alumnos values ('4', 'alumno4', 'calle4');")
        db.execSQL("insert into alumnos values ('5', 'alumno5', 'calle5');")
        db.execSQL("insert into alumnos values ('6', 'alumno6', 'calle6');")
        db.execSQL("insert into alumnos values ('7', 'alumno7', 'calle7');")
        db.execSQL("insert into alumnos values ('8', 'alumno8', 'calle8');")
        db.execSQL("insert into alumnos values ('9', 'alumno9', 'calle9');")
        db.execSQL("insert into alumnos values ('10', 'alumno10', 'calle10');")
        db.execSQL("insert into alumnos values ('11', 'alumno11', 'calle11');")
        db.execSQL("insert into alumnos values ('12', 'alumno12', 'calle12');")

        db.execSQL("create table notas (_id int primary key, " +
                "id_alumno int, descripcion  text, nota int)")
        db.execSQL("insert into notas values ('1' ,'2', 'nota clase', '3');");
        db.execSQL("insert into notas values ('2' ,'3', 'nota clase', '6');");
        db.execSQL("insert into notas values ('3' ,'4', 'nota clase', '6');");
        db.execSQL("insert into notas values ('4' ,'5', 'nota clase', '7');");



    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}