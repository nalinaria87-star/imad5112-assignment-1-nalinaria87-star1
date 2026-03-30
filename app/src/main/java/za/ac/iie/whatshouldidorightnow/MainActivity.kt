package za.ac.iie.whatshouldidorightnow

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Button declarations
        val etTime = findViewById<EditText>(R.id.etTime)
        val btnGet = findViewById<Button>(R.id.btnGet)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val tvResult = findViewById<TextView>(R.id.tvResult)


        btnClear.setOnClickListener {
            tvResult.text = ""
        }

        // Generate social suggestions based on time of day inputted by user
        btnGet.setOnClickListener {
            val input = etTime.text.toString().trim().lowercase()
            // Get user input from the text field (case handling)
            val suggestions = when (input) {
                "morning" -> listOf(
                    "Send a good morning text to friends ",
                    "Eat breakfast at the table with mum and dad",
                    "Make plans for the day with your sister",
                    "Call your grandma",
                    "Go for a walk with your neighbour"
                )

                "afternoon" -> listOf(
                    "Go to the park with your best friend",
                    "Call friends and chat",
                    "Go to a cafe with friends",
                    "Go to the tennis club"
                )

                "evening" -> listOf(
                    "Watch a few episodes of a comedy show with your sister",
                    "Watch a movie with your mum",
                    "Attend your book club session",
                    "Help the kids next door with their homework",
                    "Eat dinner at the table with your family"
                )

                "night" -> listOf(
                    "Call friends and gossip for a while",
                    "Ask mum and dad about their day",
                    "Tell dad about your day",
                    "Text your friends a goodnight text"
                )

                else -> null
            }
            // Check if input field is empty and handles user input validation, and ensures the user enters a valid time of day text
            if (suggestions == null) {
                tvResult.text = "Please enter a valid time (morning, afternoon, evening, night)"
            } else {
                val suggestions = suggestions.random()
                tvResult.text = suggestions

            }
        }
    }
}