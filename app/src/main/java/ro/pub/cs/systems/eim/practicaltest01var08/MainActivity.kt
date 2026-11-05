package ro.pub.cs.systems.eim.practicaltest01var08

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var EditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val riddleEditText = findViewById<EditText>(R.id.riddle)
        val answerEditText = findViewById<EditText>(R.id.answer)
        val btn = findViewById<Button>(R.id.btnPlay)

        btn.setOnClickListener {
            val riddleText = riddleEditText.text.toString()
            val answerText = answerEditText.text.toString()

            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("riddle", riddleText)
            intent.putExtra("answer", answerText)
            startActivity(intent)
        }

    }

}
