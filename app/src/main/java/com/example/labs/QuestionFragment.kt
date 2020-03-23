package com.example.labs

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class QuestionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    fun getPizzaName(): String {
        val pizzaInput = view?.findViewById<EditText>(R.id.pizza_input)
        var result = ""

        if (validateText()) {
            result = pizzaInput?.text.toString()
        }
        return result
    }

    private fun validateText(): Boolean {
        val pizzaInput = view?.findViewById<EditText>(R.id.pizza_input)
        var check = false
        if (pizzaInput?.text.toString() == "") {
            Toast.makeText(activity, "Name isn't present", Toast.LENGTH_LONG).show()
        } else {
            check = true
        }
        return check
    }


}
