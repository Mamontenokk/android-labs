package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun makeOrder(view: View){
        val questionFragment = supportFragmentManager.findFragmentById(R.id.question_fragment) as QuestionFragment
        val checkboxFragment = supportFragmentManager.findFragmentById(R.id.checkbox_fragment) as CheckboxFragment
        val pizzaName = questionFragment.getPizzaName()
        val pizzaIngredients = checkboxFragment.getPizzaIngridients()

        displayResults(pizzaName, pizzaIngredients)
    }

    private fun displayResults(pizzaName: String, pizzaIngredients: String){

        var resultsFragment = supportFragmentManager.findFragmentById(R.id.results_fragment) as ResultsFragment
        if(ResultsFragment.concatenate(pizzaName,pizzaIngredients) != resultsFragment.displayText){
            resultsFragment = ResultsFragment.newInstance(pizzaName,pizzaIngredients)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.results_fragment, resultsFragment)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }

    }


}
