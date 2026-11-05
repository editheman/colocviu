package ro.pub.cs.systems.eim.practicaltest01var08

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    private var wrongAnswer = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val riddleTextView = findViewById<TextView>(R.id.riddle)
        riddleTextView.text = intent.getStringExtra("riddle")

        val correctAnswer = intent.getStringExtra("answer")
        val answerEditText = findViewById<EditText>(R.id.answer)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val btnBack = findViewById<Button>(R.id.btnBack)

        if (savedInstanceState != null) {
            wrongAnswer = savedInstanceState.getBoolean("wrongAnswer", false)
            if (wrongAnswer) {
                Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()
            }
        }
        btnCheck.setOnClickListener {
            val userAnswer = answerEditText.text.toString()

            if (userAnswer == correctAnswer) {
                wrongAnswer = false
                setResult(RESULT_OK)
                finish()
            } else {
                wrongAnswer = true
                Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()
            }
        }

        btnBack.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("wrongAnswer", wrongAnswer)
    }
}
