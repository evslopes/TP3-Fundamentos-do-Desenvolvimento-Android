package com.example.elvis_lopes_dr1_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_questao1.*
import kotlinx.android.synthetic.main.fragment_questao2.*
import kotlinx.android.synthetic.main.fragment_questao2.btnProximaQuestao
import kotlinx.android.synthetic.main.fragment_questao2.radioButtonOptionA
import kotlinx.android.synthetic.main.fragment_questao2.radioButtonOptionB
import kotlinx.android.synthetic.main.fragment_questao2.radioButtonOptionC
import kotlinx.android.synthetic.main.fragment_questao2.radioButtonOptionD
import kotlinx.android.synthetic.main.fragment_questao2.radioGroupOptions
import kotlinx.android.synthetic.main.fragment_questao2.textViewQuestion

class Questao2Fragment : Fragment() {

    var pontuacaoQuestao2: Int = 0
    lateinit var radioButton: RadioButton

    val questao2 = Questoes(2,
                            "2. Qual o objetivo desse investimento?",
                            " baixos riscos de perdas",
                            "Aumento gradual do capital ao longo do tempo, " +
                                                            "assumindo riscos moderados",
                            "Aumento do capital acima da taxa de retorno média do mercado, mesmo que" +
                                                        " isso implique assumir riscos de perdas elevadas",
                            "Obter no curto prazo retornos elevados e significativamente acima da taxa " +
                                                        "de retorno média do mercado, assumindo riscos elevados",
                            null,
                            0, 2,4,5,null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questao2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questao2.questoes
        radioButtonOptionA.text = questao2.opcao1
        radioButtonOptionB.text = questao2.opcao2
        radioButtonOptionC.text = questao2.opcao3
        radioButtonOptionD.text = questao2.opcao4

        btnProximaQuestao.setOnClickListener {
            var bundlePontuacao2 = Bundle(clickRadioButton2())
            bundlePontuacao2.putInt("pontuacao2", pontuacaoQuestao2)

            findNavController().navigate(R.id.action_questao2Fragment_to_questao3Fragment2, bundlePontuacao2)
        }
    }

    private fun clickRadioButton2(): Int {
       val pontuacaoQuestao1: Int = arguments?.get("pontuacao1") as Int
       val opcaoRadioButton = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(opcaoRadioButton)

       val _questao2 = Questao2Fragment().questao2

        when {
            radioButtonOptionA.isChecked -> {
                pontuacaoQuestao2 = _questao2.pontuacao1 + pontuacaoQuestao1
            }
            radioButtonOptionB.isChecked -> {
                pontuacaoQuestao2 = _questao2.pontuacao2 + pontuacaoQuestao1
            }
            radioButtonOptionC.isChecked -> {
                pontuacaoQuestao2 = _questao2.pontuacao3 + pontuacaoQuestao1
            }
            radioButtonOptionD.isChecked -> {
                pontuacaoQuestao2 = _questao2.pontuacao4!! + pontuacaoQuestao1
            }
        }
       return pontuacaoQuestao2

    }


}