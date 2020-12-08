package com.example.elvis_lopes_dr1_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao4.*

class Questao4Fragment : Fragment() {
    var pontuacaoQuestao4: Int = 0

    lateinit var radioButton: RadioButton

    val questao4 = Questoes(4,
            "4. Considerando seus rendimentos regulares, qual a porcentagem você " +
                    "pretende reservar para aplicações Financeiras?",
            "No máximo 25%",
            "Entre 25,01 e 50%",
            "Acima de 50%",
            null,
            null,
            0, 2,4,null,null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questao4, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questao4.questoes
        radioButtonOptionA.text = questao4.opcao1
        radioButtonOptionB.text = questao4.opcao2
        radioButtonOptionC.text = questao4.opcao3


        btnProximaQuestao.setOnClickListener {
            var bundlePontuacao4 = Bundle(clickRadioButton4())
            bundlePontuacao4.putInt("pontuacao4", pontuacaoQuestao4)

            findNavController().navigate(R.id.action_questao4Fragment_to_questao5Fragment, bundlePontuacao4)
        }
    }

    private fun clickRadioButton4(): Int {
        val pontuacaoQuestao3: Int = arguments?.get("pontuacao3") as Int
        val opcaoRadioButton = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(opcaoRadioButton)

        val _questao4 = Questao4Fragment().questao4

        when {
            radioButtonOptionA.isChecked -> {
                pontuacaoQuestao4 = _questao4.pontuacao1 + pontuacaoQuestao3
            }
            radioButtonOptionB.isChecked -> {
                pontuacaoQuestao4 = _questao4.pontuacao2 + pontuacaoQuestao3
            }
            radioButtonOptionC.isChecked -> {
                pontuacaoQuestao4 = _questao4.pontuacao3 + pontuacaoQuestao3
            }
        }
        return pontuacaoQuestao4

    }

}