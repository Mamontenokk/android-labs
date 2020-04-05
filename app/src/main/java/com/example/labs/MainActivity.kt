package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.labs.ResultsFragment.Companion.concatenate
import java.io.File

const val fileName = "orders.txt"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun makeOrder(view: View) {
        val questionFragment =
            supportFragmentManager.findFragmentById(R.id.question_fragment) as QuestionFragment
        val checkboxFragment =
            supportFragmentManager.findFragmentById(R.id.checkbox_fragment) as CheckboxFragment
        val pizzaName = questionFragment.getPizzaName()
        val pizzaIngredients = checkboxFragment.getPizzaIngridients()

        writeToFile(pizzaName, pizzaIngredients)
        displayResults(pizzaName, pizzaIngredients)
    }

    fun showResults(view: View) {
        val intent = Intent(this, ResultsActivity::class.java)
        startActivity(intent)
    }

    private fun displayResults(pizzaName: String, pizzaIngredients: String) {

        var resultsFragment =
            supportFragmentManager.findFragmentById(R.id.results_fragment) as ResultsFragment
        if (ResultsFragment.concatenate(
                pizzaName,
                pizzaIngredients
            ) != resultsFragment.displayText
        ) {
            resultsFragment = ResultsFragment.newInstance(concatenate(pizzaName, pizzaIngredients))

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.results_fragment, resultsFragment)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }
    }

    private fun writeToFile(pizzaName: String, pizzaIngredients: String) {
        if (pizzaName != "" && pizzaIngredients != "") {
            val text = concatenate(pizzaName, pizzaIngredients)
            val file = File(baseContext.filesDir, fileName)
            if (file.exists()) {
                file.appendText('\n' + text +'\n')
            } else {
                file.writeText(text)
            }
        }
    }


}
