package com.example.standard_scientific_calc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlin.math.exp
import kotlin.math.ln
import kotlin.math.sqrt

class ScientificCalculatorFragment : Fragment() {

    private lateinit var functionSpinner: Spinner
    private lateinit var numEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var operationButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_scientific_calculator, container, false)

        // Find views by ID
        functionSpinner = view.findViewById(R.id.function_spinner)
        numEditText = view.findViewById(R.id.num_edit_text)
        resultTextView = view.findViewById(R.id.result_text_view)
        operationButton = view.findViewById(R.id.operation_button)

        // Set click listener for button
        operationButton.setOnClickListener {
            val function = functionSpinner.selectedItem.toString()
            val num = numEditText.text.toString().toFloat()
            val result = when (function) {
                getString(R.string.square_root) -> sqrt(num)
                getString(R.string.exponentiation) -> exp(num)
                getString(R.string.logarithm) -> ln(num)
                else -> throw IllegalArgumentException("Unknown function: $function")
            }
            resultTextView.text = result.toString()
        }

        // Set up spinner adapter and listener
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.functions_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        functionSpinner.adapter = adapter
        functionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                operationButton.text = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }


        }
        return view
    }
}




        // Set click listener for button


