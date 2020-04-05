package com.example.labs

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.nio.charset.Charset


class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstance: Bundle?){
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_results)
        val pizzaResults = findViewById<TextView>(R.id.file_results)
        val content = readFile()
        if (content == ""){
            pizzaResults.text = "File is empty"
        } else {
            pizzaResults.text = readFile()
        }


    }

    private fun readFile() : String{
        val file = File(baseContext.filesDir, fileName)
        return FileInputStream(file).bufferedReader().use { it.readText() }
    }

    fun clearFile(view: View){
        val file = File(baseContext.filesDir, fileName)
        file.writeText("")
        findViewById<TextView>(R.id.file_results).text = "File is empty"

    }
}