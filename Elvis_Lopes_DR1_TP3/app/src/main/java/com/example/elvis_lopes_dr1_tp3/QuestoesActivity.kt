package com.example.elvis_lopes_dr1_tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class QuestoesActivity : AppCompatActivity() {
    var nomeUsuario: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questoes)
        Log.i("Ciclo de vida", "Question Activity onCreate")

        nomeUsuario = intent.getStringExtra("userName").toString()
        Toast.makeText(
                this,
                "Olá $nomeUsuario",
                Toast.LENGTH_LONG
        ).show()
    }
}