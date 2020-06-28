package com.example.taller02

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences= getSharedPreferences("TALLER_KOTLIN_FORM", Context.MODE_PRIVATE)
        val user=sharedPreferences.getString("USER","")
        val password=sharedPreferences.getString("PASSWORD","")

        val userName=username.text.toString()
        val passwordmain=user


        login.setOnClickListener {


            if(userName.equals(user.toString())&&passwordmain.equals(password.toString())){
                val intent = Intent(this, LoginActivity::class.java)
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }else{
                Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
            }

        }

        registro_btn.setOnClickListener {
            val intent = Intent(this, RegistrarseActivity::class.java)
            startActivity(intent)
        }
    }
}