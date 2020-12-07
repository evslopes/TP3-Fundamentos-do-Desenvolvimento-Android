package com.example.elvis_lopes_dr1_tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var usuarioNome: String? = intent!!.getStringExtra("username").toString()
        textViewNomeUsuario.text = "Usuário: $usuarioNome"

        var pontuacao: Int = intent!!.getIntExtra("pontuacao9", 0)

        PerfilInvestidor(pontuacao)

        Toast.makeText(
            this,
            "Pontuação final: $pontuacao",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun PerfilInvestidor(pontuacaoFinal: Int) {
        if (pontuacaoFinal <= 12) {
            textViewInvestidorPerfil.text = "Investidor: Conservador"
        } else textViewInvestidorPerfil.text = if (pontuacaoFinal <= 29) {
            "Investidor: Moderado"
        } else {
            "Investidor: Arrojado"
        }
        }
}