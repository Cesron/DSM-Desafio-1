package com.example.dsm_desafio_1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        val btn:Button = findViewById(R.id.login)


        btn.setOnClickListener{
            val username = findViewById<EditText?>(R.id.username).text.toString()
            val password = findViewById<EditText?>(R.id.password).text.toString()
            val editor = sharedPreferences.edit()

            editor.putString("username",  username)
            editor.putString("password", password)
            editor.apply()

            val intent: Intent = Intent(this, Menu:: class.java)
            startActivity(intent)
        }
    }



}