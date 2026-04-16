package com.example.r2_examen

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
                precio REAL,
                plataforma TEXT,
                puntuacion REAL
            )
        """)

        db.execSQL("INSERT INTO productos(nombre, precio, plataforma, puntuacion) VALUES ('PS5', 499, 'Sony', 9.5)")
        db.execSQL("INSERT INTO productos(nombre, precio, plataforma, puntuacion) VALUES ('Xbox', 499, 'Microsoft', 9.0)")
        db.execSQL("INSERT INTO productos(nombre, precio, plataforma, puntuacion) VALUES ('Switch', 299, 'Nintendo', 8.7)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}
