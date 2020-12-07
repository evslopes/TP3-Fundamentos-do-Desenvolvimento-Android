package com.example.elvis_lopes_dr1_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao1.*

class Questao1Fragment : Fragment() {

    var pontuacaoQuestao1 = 0
    lateinit var radioButton: Button
    val questao1 = Questoes ( 1,
                    "1. Por quanto tempo você pretende deixar seu dinheiro investido",
                    "Menos de 6 meses",
                    "Entre 6 meses e 1 ano",
                    "Entre 1 ano e 3 anos",
                    "Acima de 3 anos",
                    null,
                    0,2,3,4,null
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_questao1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questao1.questoes
        radioButtonOptionA.text = questao1.opcao1
        radioButtonOptionB.text = questao1.opcao2
        radioButtonOptionC.text = questao1.opcao3
        radioButtonOptionD.text = questao1.opcao4

        btnProximaQuestao.setOnClickListener {
            var bundlePontuacao = Bundle(clickRadioButton())
            bundlePontuacao.putInt("pontuacao1",pontuacaoQuestao1)

            findNavController().navigate(R.id.action_questao1Fragment_to_questao2Fragment,bundlePontuacao)
        }

    }

    private fun clickRadioButton(): Int {
        val opcaoRadioButton = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(opcaoRadioButton)

        val _questao1 = Questao1Fragment().questao1

        when {
            radioButtonOptionA.isChecked -> {
                pontuacaoQuestao1 = _questao1.pontuacao1
            }
            radioButtonOptionB.isChecked -> {
                pontuacaoQuestao1 = _questao1.pontuacao2
            }
            radioButtonOptionC.isChecked -> {
                pontuacaoQuestao1 = _questao1.pontuacao3
            }
            radioButtonOptionD.isChecked -> pontuacaoQuestao1 = _questao1.pontuacao4!!
        }
        return pontuacaoQuestao1
    }


}