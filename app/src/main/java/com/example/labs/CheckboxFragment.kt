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


class CheckboxFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkbox, container, false)
    }

    fun getPizzaIngridients(): String {
        val cheeseCheckbox = view?.findViewById<CheckBox>(R.id.cb_cheese)
        val cucumberCheckbox = view?.findViewById<CheckBox>(R.id.cb_cucumber)
        val chickenCheckbox = view?.findViewById<CheckBox>(R.id.cb_chicken)
        var ingredients = ""
        if (validateCheckBox()) {
            ingredients = "Ingredients:"

            if (cheeseCheckbox!!.isChecked) {
                ingredients += "\n" + "Cheese"
            }
            if (cucumberCheckbox!!.isChecked) {
                ingredients += "\n" + "Cucumber"
            }
            if (chickenCheckbox!!.isChecked) {
                ingredients += "\n" + "Chicken"
            }
        }
        return ingredients


    }


    private fun validateCheckBox(): Boolean {
        val cheeseCheckbox = view?.findViewById<CheckBox>(R.id.cb_cheese)
        val cucumberCheckbox = view?.findViewById<CheckBox>(R.id.cb_cucumber)
        val chickenCheckbox = view?.findViewById<CheckBox>(R.id.cb_chicken)
        var check = false
        if (!cheeseCheckbox!!.isChecked and !cucumberCheckbox!!.isChecked and !chickenCheckbox!!.isChecked) {
            Toast.makeText(activity, "No ingridients", Toast.LENGTH_LONG).show()
        } else {
            check = true
        }
        return check
    }
}
