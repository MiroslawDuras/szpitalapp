package com.example.szpitalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class profillekarza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profillekarza)
        Toast.makeText(this, "Pomyślnie zalogowano", Toast.LENGTH_SHORT).show()
        val wyloguj = findViewById<Button>(R.id.wyloguj)

        wyloguj.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this@profillekarza, MainActivity::class.java))
            finish()

        }
    }
}