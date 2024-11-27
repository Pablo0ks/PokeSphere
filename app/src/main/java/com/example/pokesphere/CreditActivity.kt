package com.example.pokesphere

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        val userName = intent.getStringExtra("USER_NAME")
        val userWelcome = findViewById<TextView>(R.id.userWelcome)
        userWelcome.text = "$userName, estás usando la 1ª version de PokeShpere"

        val contactButton = findViewById<Button>(R.id.contactButton)
        contactButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("tu_correo@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app PokeSphere")
            }
            startActivity(emailIntent)
        }
    }
}