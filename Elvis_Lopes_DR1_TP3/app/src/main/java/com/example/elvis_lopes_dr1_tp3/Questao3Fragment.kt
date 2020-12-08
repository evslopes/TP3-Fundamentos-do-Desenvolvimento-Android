package com.example.elvis_lopes_dr1_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao3.*

class Questao3Fragment : Fragment() {

    var pontuacaoQuestao3: Int = 0

    lateinit var radioButton: RadioButton

    val questao3 = Questoes(3,
                            "Qual das alternativas melhor classifica sua formação e experiência " +
                                                                        "com o mercado Financeiro?",
                            "Não possuo formação acadêmica ou conhecimento do mercado Financeiro ",
                            "Possuo formação acadêmica na área Financeira, mas não tenho experiência " +
                                    "com o mercado Financeiro ",
                            "Possuo formação acadêmica em outra área, mas possuo conhecimento do " +
                                    "mercado Financeiro ",
                            "Possuo formação acadêmica na área Financeira ou pleno conhecimento do" +
                                    " mercado Financeiro",
                            null,
                            0, 2,4,5,null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questao3, container, false)
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            textViewQuestion.text = questao3.questoes
            radioButtonOptionA.text = questao3.opcao1
            radioButtonOptionB.text = questao3.opcao2
            radioButtonOptionC.text = questao3.opcao3
            radioButtonOptionD.text = questao3.opcao4

            btnProximaQuestao.setOnClickListener {
                var bundlePontuacao3 = Bundle(clickRadioButton3())
                bundlePontuacao3.putInt("pontuacao3", pontuacaoQuestao3)

                findNavController().navigate(R.id.action_questao3Fragment2_to_questao4Fragment, bundlePontuacao3)
            }
        }

        private fun clickRadioButton3(): Int {
                val pontuacaoQuestao2: Int = arguments?.get("pontuacao2") as Int
                val opcaoRadioButton = radioGroupOptions.checkedRadioButtonId
                radioButton = radioGroupOptions.findViewById(opcaoRadioButton)

                val _questao3 = Questao3Fragment().questao3

                when {
                    radioButtonOptionA.isChecked -> {
                        pontuacaoQuestao3 = _questao3.pontuacao1 + pontuacaoQuestao2
                    }
                    radioButtonOptionB.isChecked -> {
                        pontuacaoQuestao3 = _questao3.pontuacao2 + pontuacaoQuestao2
                    }
                    radioButtonOptionC.isChecked -> {
                        pontuacaoQuestao3 = _questao3.pontuacao3 + pontuacaoQuestao2
                    }
                    radioButtonOptionD.isChecked -> {
                        pontuacaoQuestao3 = _questao3.pontuacao4!! + pontuacaoQuestao2
                    }
                }
                return pontuacaoQuestao3

            }

        }