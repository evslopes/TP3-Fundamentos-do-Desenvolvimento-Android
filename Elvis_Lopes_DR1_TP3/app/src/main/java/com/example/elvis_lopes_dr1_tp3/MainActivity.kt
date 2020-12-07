package com.example.elvis_lopes_dr1_tp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnIniciarQuestionario: Button
    lateinit var editTextUsuarioNome: TextView
    lateinit var textViewCreditoCriadorPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIniciarQuestionario = findViewById(R.id.btnIniciarQuestionario)
        editTextUsuarioNome = findViewById(R.id.editTextUsuarioNome)

        btnIniciarQuestionario.setOnClickListener {
            var nomeUsario = editTextUsuarioNome.text.toString()

            if (nomeUsario.isEmpty()){
                Toast.makeText(this, "Informe seu nome", Toast.LENGTH_LONG).show()
            } else {
                val alterActivity = Intent(this, QuestoesActivity::class.java)
                alterActivity.putExtra("userName", nomeUsario)
                startActivity(alterActivity)
            }
        }




    }
}