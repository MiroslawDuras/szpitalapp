package com.example.szpitalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class zalogujsiepacjent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zalogujsiepacjent)
        val context = this


        val cofnijbutton = findViewById<Button>(R.id.cofnij3)
        val zalogujsiebutton = findViewById<Button>(R.id.zalogujsiebutton2)
        val poleEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val poleHaslo = findViewById<EditText>(R.id.editTextTextPassword)

        cofnijbutton.setOnClickListener {
            val intent = Intent(context, zalogujsie::class.java)
            startActivity(intent)
            finish()
        }

        zalogujsiebutton.setOnClickListener {



                if(poleEmail.text.toString().isEmpty())
                {
                    Toast.makeText(this@zalogujsiepacjent, "Prosze wpisać adres email", Toast.LENGTH_LONG).show()

                }

                if(poleHaslo.text.toString().isEmpty())
                {
                    Toast.makeText(this@zalogujsiepacjent, "Prosze wpisać hasło", Toast.LENGTH_LONG).show()

                }


                else
                {
                    val email: String = poleEmail.text.toString().trim() { it <= ' '}
                    val password: String = poleHaslo.text.toString().trim() { it <= ' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(
                        OnCompleteListener<AuthResult> { task ->
                            if(task.isSuccessful){
                                val firebaseUser: FirebaseUser = task.result!!.user!!


                                val intent = Intent(this@zalogujsiepacjent, profilpacjenta::class.java)
                                intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            }
                            else
                            {
                                Toast.makeText(this@zalogujsiepacjent,task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                        })
                }

            }


        }

    }
