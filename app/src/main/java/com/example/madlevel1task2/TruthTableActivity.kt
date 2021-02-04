package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityTruthTableBinding

class TruthTableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTruthTableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTruthTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start checking the answers when the submit button is clicked.
        binding.btnSubmit.setOnClickListener {
            checkAnswers()
        }
    }

    // Calculate and display the amount of correct answers.
    private fun checkAnswers() {
        // Calculate the amount of correct answers with a counter.
        var rightAnswers: Int = 0
        if (binding.etAnswerTT.text.toString() == "T") {
            rightAnswers += 1
        }
        if (binding.etAnswerTF.text.toString() == "F") {
            rightAnswers += 1
        }
        if (binding.etAnswerFT.text.toString() == "F") {
            rightAnswers += 1
        }
        if (binding.etAnswerFF.text.toString() == "F") {
            rightAnswers += 1
        }
        // Display a Toast message if not all input fields are filled in.
        if (binding.etAnswerTT.text.toString().isBlank() or binding.etAnswerTF.text.toString().isBlank() or binding.etAnswerFT.text.toString().isBlank() or binding.etAnswerFF.text.toString().isBlank()) {
            rightAnswers = 5
        }

        // Display a Toast message with the amount of correct answers.
        when (rightAnswers) {
            0 -> Toast.makeText(this, R.string.zero, Toast.LENGTH_LONG).show()
            1 -> Toast.makeText(this, R.string.one, Toast.LENGTH_LONG).show()
            2 -> Toast.makeText(this, R.string.two, Toast.LENGTH_LONG).show()
            3 -> Toast.makeText(this, R.string.three, Toast.LENGTH_LONG).show()
            4 -> Toast.makeText(this, R.string.four, Toast.LENGTH_LONG).show()
            else -> Toast.makeText(this, R.string.empty, Toast.LENGTH_LONG).show()
        }
    }
}