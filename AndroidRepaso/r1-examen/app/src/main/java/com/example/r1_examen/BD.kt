package com.example.r1_examen

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BD(context: Context) :
    SQLiteOpenHelper(context, "videojuegos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("""
            CREATE TABLE videojuegos(
                id_juego INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT,
                plataforma TEXT,
                precio DOUBLE
            )
        """)

        db.execSQL("INSERT INTO videojuegos(titulo, plataforma, precio) VALUES ('God of War', 'PS5', 59.99)")
        db.execSQL("INSERT INTO videojuegos(titulo, plataforma, precio) VALUES ('Halo Infinite', 'XBOX', 49.99)")
        db.execSQL("INSERT INTO videojuegos(titulo, plataforma, precio) VALUES ('Zelda TOTK', 'Switch', 69.99)")
        db.execSQL("INSERT INTO videojuegos(titulo, plataforma, precio) VALUES ('Cyberpunk 2077', 'PC', 39.99)")

        db.execSQL("""
            CREATE TABLE jugadores(
                id_jugador INTEGER PRIMARY KEY AUTOINCREMENT,
                id_juego INTEGER,
                nombre TEXT,
                horas INTEGER
            )
        """)

        db.execSQL("INSERT INTO jugadores(id_juego, nombre, horas) VALUES (1, 'Pedro', 120)")
        db.execSQL("INSERT INTO jugadores(id_juego, nombre, horas) VALUES (1, 'Laura', 50)")
        db.execSQL("INSERT INTO jugadores(id_juego, nombre, horas) VALUES (3, 'Manuel', 200)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}
