package com.example.repaso

import android.annotation.SuppressLint import android.content.Intent import android.database.sqlite.SQLiteDatabase import android.os.Bundle import android.view.View import android.widget.ArrayAdapter import android.widget.EditText import android.widget.ListView import android.widget.Spinner import androidx.activity.enableEdgeToEdge import androidx.appcompat.app.AppCompatActivity import androidx.core.view.ViewCompat import androidx.core.view.WindowInsetsCompat
import kotlin.reflect.KClass
class MainActivity : AppCompatActivity() {
    //Para poder acceder tener como sacar las funciones
    lateinit var inputID: EditText
    lateinit var inputNombre: EditText
    lateinit var inputAnio: EditText
    lateinit var inputTitulo: EditText
    lateinit var puntuacion: EditText
    lateinit var db: SQLiteDatabase
    lateinit var spinner: Spinner

    lateinit var list: ListView

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Inicializar variables
        inputNombre = findViewById<EditText>(R.id.idVideo)
        inputTitulo = findViewById<EditText>(R.id.idTitulo)
        inputAnio = findViewById<EditText>(R.id.idAnio)
        puntuacion = findViewById<EditText>(R.id.idPuntuacion)
        list = findViewById<ListView>(R.id.idList)

        //Crear la base de datos
        val bd = BD(this)

        //Para poeder hacer consultar
        db = bd.readableDatabase

        //SPINNER
        //Crear las opciones del spinner
        var opciones = arrayOf<String>("PS5", "XBOX", "PSVITA", "PSP", "MANTENDO")

        //Seleccionar el spinner de la vista
        spinner = findViewById<Spinner>(R.id.idPlataforma)

        //Meter las opciones en el spinner
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)

        //BUSCAR
        inputID = findViewById<EditText>(R.id.idVideo)

        cargarListas()

    }

    //FUNCION PARA BUSCAR JUEGOS Y CARACTERISTICAS POR ID
    fun buscarId(view: View){
        var id = inputID.text.toString().toInt()

        var cursor = db.rawQuery("SELECT * FROM videojuegos where id = ?", arrayOf(id.toString()))

        if(cursor.moveToFirst()){
            //Sacar cada columna y ponerla con el nombre
            inputTitulo.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")))
            inputAnio.setText(cursor.getString(cursor.getColumnIndexOrThrow("anio")))
            inputID.setText(cursor.getString(cursor.getColumnIndexOrThrow("id")))
            puntuacion.setText(cursor.getString(cursor.getColumnIndexOrThrow("puntuacion")))

            var plataforma = cursor.getString(cursor.getColumnIndexOrThrow("plataforma"))
            var posicion = (spinner.adapter as ArrayAdapter<String>).getPosition(plataforma)

            if(posicion>=0)
                spinner.setSelection(posicion)

        }
    }

    fun buscarTitulo(view: View){
        var id = inputTitulo.text.toString()

        var cursor = db.rawQuery("SELECT * FROM videojuegos where titulo = ?", arrayOf(inputTitulo.text.toString()))

        if(cursor.moveToFirst()){
            //Sacar cada columna y ponerla con el nombre
            inputTitulo.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")))
            inputAnio.setText(cursor.getString(cursor.getColumnIndexOrThrow("anio")))
            inputID.setText(cursor.getString(cursor.getColumnIndexOrThrow("id")))
            puntuacion.setText(cursor.getString(cursor.getColumnIndexOrThrow("puntuacion")))

            var plataforma = cursor.getString(cursor.getColumnIndexOrThrow("plataforma"))
            var posicion = (spinner.adapter as ArrayAdapter<String>).getPosition(plataforma)

            if(posicion>=0)
                spinner.setSelection(posicion)

        }
    }

    fun siguiente(view: View) {

        // 1. Obtener el ID actual del registro mostrado
        val idActual = inputID.text.toString().toInt()

        // 2. Calcular el siguiente ID
        val siguienteId = idActual + 1

        // 3. Intentar cargar el siguiente registro
        var cursor = db.rawQuery(
            "SELECT * FROM videojuegos WHERE id = ?",
            arrayOf(siguienteId.toString())
        )

        if (cursor.moveToFirst()) {
            // Si existe, mostrarlo
            mostrarRegistro(cursor)
        } else {
            // Si NO existe, volver al primero
            cursor.close()
            cursor = db.rawQuery(
                "SELECT * FROM videojuegos ORDER BY id LIMIT 1",
                null
            )

            if (cursor.moveToFirst()) {
                mostrarRegistro(cursor)
            }
        }

        cursor.close()
    }
    fun anterior(view: View) {

        val idActual = inputID.text.toString().toInt()
        val anteriorId = idActual - 1

        // Intentar cargar el anterior
        var cursor = db.rawQuery(
            "SELECT * FROM videojuegos WHERE id = ?",
            arrayOf(anteriorId.toString())
        )

        if (cursor.moveToFirst()) {
            mostrarRegistro(cursor)
        } else {
            // Si no existe, ir al último
            cursor.close()
            cursor = db.rawQuery(
                "SELECT * FROM videojuegos ORDER BY id DESC LIMIT 1",
                null
            )

            if (cursor.moveToFirst()) {
                mostrarRegistro(cursor)
            }
        }

        cursor.close()
    }


    fun ultimo(view: View) {
        val cursor = db.rawQuery(
            "SELECT * FROM videojuegos ORDER BY id DESC LIMIT 1",
            null
        )

        if (cursor.moveToFirst()) {
            mostrarRegistro(cursor)
        }

        cursor.close()
    }

    fun primero(view: View) {
        val cursor = db.rawQuery(
            "SELECT * FROM videojuegos ORDER BY id ASC LIMIT 1",
            null
        )

        if (cursor.moveToFirst()) {
            mostrarRegistro(cursor)
        }

        cursor.close()
    }

    fun insertar(view: View) {

        val titulo = inputTitulo.text.toString()
        val anio = inputAnio.text.toString()
        val puntu = puntuacion.text.toString()
        val plataforma = spinner.selectedItem.toString()

        if (titulo.isEmpty() || anio.isEmpty() || puntu.isEmpty()) {
            return
        }

        db.execSQL(
            "INSERT INTO videojuegos (titulo, anio, puntuacion, plataforma) VALUES (?, ?, ?, ?)",
            arrayOf(titulo, anio, puntu, plataforma)
        )

        cargarListas()   // refresca el ListView
    }

    fun borrar(view: View) {

        val id = inputID.text.toString()

        if (id.isEmpty()) {
            return
        }

        db.execSQL(
            "DELETE FROM videojuegos WHERE id = ?",
            arrayOf(id)
        )

        cargarListas()   // refresca el ListView
    }


    fun mostrarRegistro(cursor: android.database.Cursor) {
        inputTitulo.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")))
        inputAnio.setText(cursor.getString(cursor.getColumnIndexOrThrow("anio")))
        inputID.setText(cursor.getString(cursor.getColumnIndexOrThrow("id")))
        puntuacion.setText(cursor.getString(cursor.getColumnIndexOrThrow("puntuacion")))

        val plataforma = cursor.getString(cursor.getColumnIndexOrThrow("plataforma"))
        val posicion = (spinner.adapter as ArrayAdapter<String>).getPosition(plataforma)

        if (posicion >= 0)
            spinner.setSelection(posicion)
    }

    fun cargarListas(){
        var cursor = db.rawQuery("SELECT * FROM videojuegos", null)
        val datos = ArrayList<Videojuego>()

        if(cursor.moveToFirst()){
            do {
                var id = cursor.getString(cursor.getColumnIndexOrThrow("id"))
                var titulo = cursor.getString(cursor.getColumnIndexOrThrow("titulo"))
                var plataforma = cursor.getString(cursor.getColumnIndexOrThrow("plataforma"))
                var puntuacion = cursor.getString(cursor.getColumnIndexOrThrow("puntuacion"))
                var anio = cursor.getString(cursor.getColumnIndexOrThrow("anio"))

                datos.add(Videojuego(id.toString().toInt(),titulo,anio.toString().toInt(),puntuacion.toString().toDouble(), plataforma));
            }while (cursor.moveToNext())
        }

        cursor.close()

        val adapter= Adapter(this, datos)
        list.adapter = adapter
    }

    fun irA(view: View){
        val intent = Intent(this, SegundaActivity::class.java)

        intent.putExtra("titulo", inputTitulo.text.toString())
        intent.putExtra("plataforma", inputNombre.text.toString())
        intent.putExtra("puntuacion", puntuacion.text.toString())

        startActivity(intent)
    }

}