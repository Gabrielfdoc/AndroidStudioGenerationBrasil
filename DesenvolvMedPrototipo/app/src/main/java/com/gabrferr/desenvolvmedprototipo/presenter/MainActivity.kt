package com.gabrferr.desenvolvmedprototipo.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.gabrferr.desenvolvmedprototipo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.mytoolbar)

        val tituloToolbar = findViewById<TextView>(R.id.toolbar_title)
        tituloToolbar.text = "Nova postagem"

        toolbar.title = ""
        setSupportActionBar(toolbar)
    }
}