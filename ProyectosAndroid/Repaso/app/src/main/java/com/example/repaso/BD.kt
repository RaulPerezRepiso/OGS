package com.example.repaso

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BD(context: Context) :
    SQLiteOpenHelper(context, "videojuegos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE videojuegos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT NOT NULL,
                plataforma TEXT NOT NULL,
                anio INTEGER,
                puntuacion REAL
            );
            """
        )

        db.execSQL(
            """
            INSERT INTO videojuegos (titulo, plataforma, anio, puntuacion) VALUES
            ('The Witcher 3', 'PC', 2015, 9.8),
            ('God of War', 'PS5', 2022, 9.5),
            ('Zelda: Breath of the Wild', 'Switch', 2017, 9.7),
            ('Halo Infinite', 'Xbox', 2021, 8.2),
            ('Minecraft', 'PC', 2011, 9.0);
            """
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS videojuegos")
        onCreate(db)
    }
}