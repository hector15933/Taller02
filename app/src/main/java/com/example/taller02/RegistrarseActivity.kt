package com.example.taller02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registrarse.*

class RegistrarseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)


        val sharedPreferences= getSharedPreferences("TALLER_KOTLIN_FORM", Context.MODE_PRIVATE)
        saveBtn.setOnClickListener {
            val name=nameEt_edt.text.toString().trim()
            val apellidos=apellido_edt.text.toString()
            val dni=dni_edt.text.toString()
            val direccion=direccion_edt.toString()
            val user=usuario_edt.text.toString()
            val password=password_edt_registro.text.toString()
            val experienced=switchh.isChecked

            val editor=sharedPreferences.edit()

            editor.putString("NAME",name)
            editor.putString("APELLIDOS",apellidos)
            editor.putString("DNI",dni)
            editor.putString("DIRECCION",direccion)
            editor.putString("USER",user)
            editor.putString("PASSWORD",password)
            editor.putBoolean("EXPERIENCED",experienced)

            editor.apply()

        }

    }
}