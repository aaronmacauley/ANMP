package com.example.adv160720015week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import kotlin.random.Random
class GameFragment : Fragment() {
    var total =0;
    var point = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnAnswer = view.findViewById<Button>(R.id.btnAnswer);
        val num1 = view.findViewById<TextView>(R.id.txtNumber1);
        val num2= view.findViewById<TextView>(R.id.txtNumber2);



        fun generateRandomNumbers() {
            val randomNum1 = Random.nextInt(1, 20)
            val randomNum2 = Random.nextInt(1, 100)
            num1.text = randomNum1.toString()
            num2.text = randomNum2.toString()
            total = randomNum1 + randomNum2

        }
        generateRandomNumbers()
        if (arguments!=null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            val txtTurn = view.findViewById<TextView>(R.id.txtTurn)
            txtTurn.text= "$playerName's turn";
        }
        btnAnswer.setOnClickListener{
            val randomNum1 = Random.nextInt(1, 20)
            val randomNum2 = Random.nextInt(1, 10)
            val txtAnswer = view.findViewById<EditText>(R.id.txtAnswer);
            val answerText = txtAnswer.text.toString()
            val answer = answerText.toIntOrNull()
            if (answer == total) {
                point++

            }
            else{
                val action = GameFragmentDirections.actionResultFragment(point)
                Navigation.findNavController(it).navigate(action)
            }

            generateRandomNumbers()
        }


    }
}