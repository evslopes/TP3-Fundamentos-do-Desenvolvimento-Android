package com.example.elvis_lopes_dr1_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao6.*

class Questao6Fragment : Fragment() {
    var pontuacaoQuestao6: Int = 0

    lateinit var radioButton: RadioButton

    val questao6 = Questoes(6,
            "6. Como está distribuído o seu patrimônio?",
            "Meu patrimônio não está aplicado ou está todo aplicado em renda Fixa " +
                    "e/ou imóveis",
            "Menos de 25% em renda variável e o restante em renda Fixa e/ou imóveis ",
            "Entre 25,01 e 50% aplicado em renda variável e o restante em renda Fixa " +
                    "e/ou imóveis",
            "Acima de 50% em renda variável",
            null,
            0, 2,3,4,null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questao6, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questao6.questoes
        radioButtonOptionA.text = questao6.opcao1
        radioButtonOptionB.text = questao6.opcao2
        radioButtonOptionC.text = questao6.opcao3
        radioButtonOptionD.text = questao6.opcao4

        btnProximaQuestao.setOnClickListener {
            var bundlePontuacao6 = Bundle(clickRadioButton6())
            bundlePontuacao6.putInt("pontuacao6", pontuacaoQuestao6)

            findNavController().navigate(R.id.action_questao6Fragment_to_questao7Fragment, bundlePontuacao6)
        }
    }

    private fun clickRadioButton6(): Int {
        val pontuacaoQuestao5: Int = arguments?.get("pontuacao5") as Int
        val opcaoRadioButton = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(opcaoRadioButton)

        val _questao6 = Questao6Fragment().questao6

        when {
            radioButtonOptionA.isChecked -> {
                pontuacaoQuestao6 = _questao6.pontuacao1 + pontuacaoQuestao5
            }
            radioButtonOptionB.isChecked -> {
                pontuacaoQuestao6 = _questao6.pontuacao2 + pontuacaoQuestao5
            }
            radioButtonOptionC.isChecked -> {
                pontuacaoQuestao6 = _questao6.pontuacao3 + pontuacaoQuestao5
            }
            radioButtonOptionD.isChecked -> {
                pontuacaoQuestao6 = _questao6.pontuacao4!! + pontuacaoQuestao5
            }
        }
        return pontuacaoQuestao6

    }
}