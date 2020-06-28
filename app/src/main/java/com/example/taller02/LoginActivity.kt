package com.example.taller02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login2.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login2)

        val sharedPreferences= getSharedPreferences("TALLER_KOTLIN_FORM", Context.MODE_PRIVATE)
        saveBtn.setOnClickListener {
            val name=nameEt_edt.text.toString().trim()
            val apellidos=apellido_edt.text.toString()
            val dni=dni_edt.text.toString()
            val direccion=direccion_edt.text.toString()
            val experienced=switchh.isChecked
            val user=sharedPreferences.getString("USER","")
            val password=sharedPreferences.getString("PASSWORD","")

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
        showInfoBtn.setOnClickListener {
            val name=sharedPreferences.getString("NAME","")
            val apellidos=sharedPreferences.getString("APELLIDOS","")
            val dni=sharedPreferences.getString("DNI","")
            val direccion=sharedPreferences.getString("DIRECCION","")
            val user=sharedPreferences.getString("USER","")
            val password=sharedPreferences.getString("PASSWORD","")
            val experienced=sharedPreferences.getBoolean("EXPERIENCED",false)


            val nameEt_edt: EditText = findViewById(R.id.nameEt_edt)
            val apellido_edt: EditText = findViewById(R.id.apellido_edt)
            val dni_edt: EditText = findViewById(R.id.dni_edt)
            val direccion_edt: EditText = findViewById(R.id.direccion_edt)

            nameEt_edt.setText(name.toString())
            apellido_edt.setText(apellidos.toString())
            dni_edt.setText(dni.toString())
            direccion_edt.setText(direccion.toString())


            infoTv.text="Name:$name \nApellidos:$apellidos"
        }
    }


}