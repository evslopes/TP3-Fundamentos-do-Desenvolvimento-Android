package com.example.elvis_lopes_dr1_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao7.*

class Questao7Fragment : Fragment() {
    var pontuacaoQuestao7: Int = 0

    lateinit var radioButton: RadioButton

    val questao7 = Questoes(7,
            "7. Em relação as aplicações e rendimentos, em qual dessas situações você " +
                    "se enquadra?",
            "Conto com o rendimento dessas aplicações para complementar minha renda " +
                    "mensal",
            "Eventualmente posso resgatar parte das aplicações para fazer frente aos " +
                    "meus gastos. Contudo, não tenho intenção de resgatar no curto prazo e " +
                    "pretendo fazer aplicações regulares",
            "Não tenho intenção de resgatar no curto prazo, mas não pretendo realizar " +
                    "novas aplicações",
            "Não tenho intenção de resgatar no curto prazo e ainda pretendo fazer " +
                    "aplicações regulares",
            null,
            0, 2,3,4,null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questao7, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questao7.questoes
        radioButtonOptionA.text = questao7.opcao1
        radioButtonOptionB.text = questao7.opcao2
        radioButtonOptionC.text = questao7.opcao3
        radioButtonOptionD.text = questao7.opcao4

        btnProximaQuestao.setOnClickListener {
            var bundlePontuacao7 = Bundle(clickRadioButton6())
            bundlePontuacao7.putInt("pontuacao7", pontuacaoQuestao7)

            findNavController().navigate(R.id.action_questao7Fragment_to_questao8Fragment, bundlePontuacao7)
        }
    }

    private fun clickRadioButton6(): Int {
        val pontuacaoQuestao6: Int = arguments?.get("pontuacao6") as Int
        val opcaoRadioButton = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(opcaoRadioButton)

        val _questao7 = Questao6Fragment().questao6

        when {
            radioButtonOptionA.isChecked -> {
                pontuacaoQuestao7 = _questao7.pontuacao1 + pontuacaoQuestao6
            }
            radioButtonOptionB.isChecked -> {
                pontuacaoQuestao7 = _questao7.pontuacao2 + pontuacaoQuestao6
            }
            radioButtonOptionC.isChecked -> {
                pontuacaoQuestao7 = _questao7.pontuacao3 + pontuacaoQuestao6
            }
            radioButtonOptionD.isChecked -> {
                pontuacaoQuestao7 = _questao7.pontuacao4!! + pontuacaoQuestao6
            }
        }
        return pontuacaoQuestao7

    }
}