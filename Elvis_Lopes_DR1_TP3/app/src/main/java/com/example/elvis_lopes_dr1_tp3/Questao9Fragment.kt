package com.example.elvis_lopes_dr1_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao9.*

class Questao9Fragment : Fragment() {
    var pontuacaoQuestao9: Int = 0

    lateinit var radioButton: RadioButton

    val questao9 = Questoes(9,
            "9. Qual o valor aproximado do seu patrimônio?",
            "Até R$ 10.000",
            "De R$ 10.001 até R$ 100.00",
            "De R$ 100.001 até R$ 500.000",
            "De R$ 500.001 até R$ 1.000.000",
            "Acima de R$ 1.000.001",
            0, 1,2,4,5)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questao9, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questao9.questoes
        radioButtonOptionA.text = questao9.opcao1
        radioButtonOptionB.text = questao9.opcao2
        radioButtonOptionC.text = questao9.opcao3
        radioButtonOptionD.text = questao9.opcao4
        radioButtonOptionE.text = questao9.opcao5

        btnProximaQuestao.setOnClickListener {
            var bundlePontuacao9 = Bundle(clickRadioButton9())
            bundlePontuacao9.putInt("pontuacao9", pontuacaoQuestao9)

            findNavController().navigate(R.id.action_questao9Fragment_to_resultadoActivity, bundlePontuacao9)
        }
    }

    private fun clickRadioButton9(): Int {
        val pontuacaoQuestaoAnterior: Int = arguments?.get("pontuacao8") as Int
        val opcaoRadioButton = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(opcaoRadioButton)

        val _questao9 = Questao9Fragment().questao9

        when {
            radioButtonOptionA.isChecked -> {
                pontuacaoQuestao9 = _questao9.pontuacao1 + pontuacaoQuestaoAnterior
            }
            radioButtonOptionB.isChecked -> {
                pontuacaoQuestao9 = _questao9.pontuacao2 + pontuacaoQuestaoAnterior
            }
            radioButtonOptionC.isChecked -> {
                pontuacaoQuestao9 = _questao9.pontuacao3 + pontuacaoQuestaoAnterior
            }
            radioButtonOptionD.isChecked -> {
                pontuacaoQuestao9 = _questao9.pontuacao4!! + pontuacaoQuestaoAnterior
            }radioButtonOptionE.isChecked -> {
                pontuacaoQuestao9 = _questao9.pontuacao5!! + pontuacaoQuestaoAnterior
            }
        }
        return pontuacaoQuestao9

    }
}