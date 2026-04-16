package com.example.r3_examen

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BD(context: Context) :
    SQLiteOpenHelper(context, "juegos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE juegos(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT,
                plataforma TEXT,
                anio INTEGER,
                puntuacion REAL
            )
        """)

        db.execSQL("INSERT INTO juegos(nombre, plataforma, anio, puntuacion) VALUES ('God of War', 'PS5', 2022, 9.8)")
        db.execSQL("INSERT INTO juegos(nombre, plataforma, anio, puntuacion) VALUES ('Halo Infinite', 'XBOX', 2021, 8.7)")
        db.execSQL("INSERT INTO juegos(nombre, plataforma, anio, puntuacion) VALUES ('Zelda TOTK', 'Switch', 2023, 10.0)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}
