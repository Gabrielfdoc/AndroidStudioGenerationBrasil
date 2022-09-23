package com.gabrferr.activitiesandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNext = findViewById<Button>(R.id.buttonProximo)

        val intentSegundaActivity = Intent(this, SegundaActivity::class.java)

        buttonNext.setOnClickListener {
            startActivity(intentSegundaActivity)
        }
    }
}