package com.example.elvis_lopes_dr1_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao8.*

class Questao8Fragment : Fragment() {
    var pontuacaoQuestao8: Int = 0

    lateinit var radioButton: RadioButton

    val questao8 = Questoes(8,
            "8. Qual sua faixa de renda mensal média?",
            "Até R$ 1.000",
            "De R$ 1.001 até R$ 5.000",
            "De R$ 5.001 até R$ 10.000",
            "Acima de R$ 10.000",
            null,
            0, 1,2,4,null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questao8, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questao8.questoes
        radioButtonOptionA.text = questao8.opcao1
        radioButtonOptionB.text = questao8.opcao2
        radioButtonOptionC.text = questao8.opcao3
        radioButtonOptionD.text = questao8.opcao4

        btnProximaQuestao.setOnClickListener {
            var bundlePontuacao8 = Bundle(clickRadioButton8())
            bundlePontuacao8.putInt("pontuacao8", pontuacaoQuestao8)

            findNavController().navigate(R.id.action_questao8Fragment_to_questao9Fragment, bundlePontuacao8)
        }
    }

    private fun clickRadioButton8(): Int {
        val pontuacaoQuestao7: Int = arguments?.get("pontuacao7") as Int
        val opcaoRadioButton = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(opcaoRadioButton)

        val _questao8 = Questao8Fragment().questao8

        when {
            radioButtonOptionA.isChecked -> {
                pontuacaoQuestao8 = _questao8.pontuacao1 + pontuacaoQuestao7
            }
            radioButtonOptionB.isChecked -> {
                pontuacaoQuestao8 = _questao8.pontuacao2 + pontuacaoQuestao7
            }
            radioButtonOptionC.isChecked -> {
                pontuacaoQuestao8 = _questao8.pontuacao3 + pontuacaoQuestao7
            }
            radioButtonOptionD.isChecked -> {
                pontuacaoQuestao8 = _questao8.pontuacao4!! + pontuacaoQuestao7
            }
        }
        return pontuacaoQuestao8

    }
}