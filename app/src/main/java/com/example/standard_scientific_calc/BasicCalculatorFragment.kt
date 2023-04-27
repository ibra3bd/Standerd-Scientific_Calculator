import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.standard_scientific_calc.R

class BasicCalculatorFragment : Fragment() {

    private lateinit var num1EditText: EditText
    private lateinit var num2EditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_basic_calculator, container, false)

        // Find views by ID
        num1EditText = view.findViewById(R.id.num1_edit_text)
        num2EditText = view.findViewById(R.id.num2_edit_text)
        resultTextView = view.findViewById(R.id.result_text_view)

        // Set click listeners for buttons
        view.findViewById<Button>(R.id.add_button).setOnClickListener {
            calculateResult(Operation.ADDITION)
        }
        view.findViewById<Button>(R.id.subtract_button).setOnClickListener {
            calculateResult(Operation.SUBTRACTION)
        }
        view.findViewById<Button>(R.id.multiply_button).setOnClickListener {
            calculateResult(Operation.MULTIPLICATION)
        }
        view.findViewById<Button>(R.id.divide_button).setOnClickListener {
            calculateResult(Operation.DIVISION)
        }

        return view
    }

    private fun calculateResult(operation: Operation) {
        val num1 = num1EditText.text.toString().toFloat()
        val num2 = num2EditText.text.toString().toFloat()
        val result = when (operation) {
            Operation.ADDITION -> num1 + num2
            Operation.SUBTRACTION -> num1 - num2
            Operation.MULTIPLICATION -> num1 * num2
            Operation.DIVISION -> num1 / num2
        }
        resultTextView.text = getString(R.string.result_format, result)
    }

    enum class Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }
}
