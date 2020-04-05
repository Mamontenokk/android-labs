package com.example.labs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

const val TEXT_KEY = "TEXT"


class ResultsFragment : Fragment() {
    val displayText: String by lazy {
        arguments?.getString(TEXT_KEY) ?: ""
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_results, container, false)
        val pizzaResults = view.findViewById<TextView>(R.id.pizza_results)
        pizzaResults.text = displayText

        return view
    }


    companion object {
        fun newInstance(composedText: String): ResultsFragment {
            val fragment = ResultsFragment()

            val args = Bundle()
            args.putString(TEXT_KEY, composedText)

            fragment.arguments = args

            return fragment
        }


        fun concatenate(pizzaName: String, pizzaIngridients: String): String {
            return "$pizzaName\n$pizzaIngridients"
        }
    }
}
