package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            calculateBMI();
        }
    }

    private fun calculateBMI(){
        if (editTextWeight.text.isEmpty()) {
            editTextWeight.setError(getString(R.string.error_input));
            return
        }
        if (editTextHeight.text.isEmpty()) {
           editTextHeight.setError(getString(R.string.error_input));
            return
        }

        val weight = editTextWeight.text.toString().toInt();
        val height = editTextHeight.text.toString().toFloat();

        val bmi = weight / height.pow(2);

        textViewBMI.text = getString(R.string.bmi) + ": " + String.format("%.2f", bmi);
        if (bmi < 18.5) {
            imageViewBMI.setImageResource(R.drawable.under);
            textViewStatus.text = getString(R.string.status) + ": Underweight"
        } else if (bmi < 25) {
            imageViewBMI.setImageResource(R.drawable.normal);
            textViewStatus.text = getString(R.string.status) + ": Normal";
        } else {
            imageViewBMI.setImageResource(R.drawable.over);
            textViewStatus.text = getString(R.string.status) + ": Overweight";
        }
    }
}
