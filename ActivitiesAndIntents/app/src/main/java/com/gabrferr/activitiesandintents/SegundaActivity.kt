package com.gabrferr.activitiesandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val buttonReturn = findViewById<Button>(R.id.buttonVoltar)

        buttonReturn.setOnClickListener {
            finish()
        }
    }
}