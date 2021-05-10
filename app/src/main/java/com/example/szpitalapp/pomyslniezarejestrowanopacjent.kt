package com.example.szpitalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class pomyslniezarejestrowanopacjent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pomyslniezarejestrowanopacjent)
        val context = this
        val zalogujsie = findViewById<Button>(R.id.zalogujsiebutton2)

        zalogujsie.setOnClickListener {
            val intent = Intent(context, zalogujsiepacjent::class.java)
            startActivity(intent)
            finish()
        }
    }
}