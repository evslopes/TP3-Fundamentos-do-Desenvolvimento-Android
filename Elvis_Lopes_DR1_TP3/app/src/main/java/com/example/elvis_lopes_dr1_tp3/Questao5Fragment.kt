package com.example.elvis_lopes_dr1_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao5.*

class Questao5Fragment : Fragment() {
    var pontuacaoQuestao5: Int = 0

    lateinit var radioButton: RadioButton

    val questao5 = Questoes(5,
            "5. Caso as suas aplicações sofressem uma queda superior a 30%, " +
                        "o que você faria?",
            "Resgataria toda a aplicação e aplicaria na poupança",
            "Manteria aplicação aguardando uma melhora do mercado",
            "Aumentaria a aplicação para aproveitar as oportunidades do mercado",
            null,
            null,
            0, 2,4,null,null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questao5, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questao5.questoes
        radioButtonOptionA.text = questao5.opcao1
        radioButtonOptionB.text = questao5.opcao2
        radioButtonOptionC.text = questao5.opcao3


        btnProximaQuestao.setOnClickListener {
            var bundlePontuacao5 = Bundle(clickRadioButton5())
            bundlePontuacao5.putInt("pontuacao5", pontuacaoQuestao5)

            findNavController().navigate(R.id.action_questao5Fragment_to_questao6Fragment, bundlePontuacao5)
        }
    }

    private fun clickRadioButton5(): Int {
        val pontuacaoQuestao4: Int = arguments?.get("pontuacao4") as Int
        val opcaoRadioButton = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(opcaoRadioButton)

        val _questao5 = Questao5Fragment().questao5

        when {
            radioButtonOptionA.isChecked -> {
                pontuacaoQuestao5 = _questao5.pontuacao1 + pontuacaoQuestao4
            }
            radioButtonOptionB.isChecked -> {
                pontuacaoQuestao5 = _questao5.pontuacao2 + pontuacaoQuestao4
            }
            radioButtonOptionC.isChecked -> {
                pontuacaoQuestao5 = _questao5.pontuacao3 + pontuacaoQuestao4
            }
        }
        return pontuacaoQuestao5

    }
}