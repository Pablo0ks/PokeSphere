package com.example.pokesphere

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput = findViewById<EditText>(R.id.userInput)
        val navigateButton = findViewById<Button>(R.id.navigateButton)

        navigateButton.setOnClickListener {
            val userName = userInput.text.toString()
            val intent = Intent(this, CreditActivity::class.java)
            intent.putExtra("USER_NAME", userName)
            startActivity(intent)
        }
    }
}