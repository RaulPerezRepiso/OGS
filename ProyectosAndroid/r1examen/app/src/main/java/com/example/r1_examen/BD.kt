package com.example.r1_examen

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BD(context: Context) :
    SQLiteOpenHelper(context, "tienda.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE productos(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT,
                precio REAL
            )
        """)

        db.execSQL("INSERT INTO productos(nombre, precio) VALUES ('PS5', 499)")
        db.execSQL("INSERT INTO productos(nombre, precio) VALUES ('Xbox', 499)")
        db.execSQL("INSERT INTO productos(nombre, precio) VALUES ('Switch', 299)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}
