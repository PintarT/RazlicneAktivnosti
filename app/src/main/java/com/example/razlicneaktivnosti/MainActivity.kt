package com.example.razlicneaktivnosti

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var st: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        st = findViewById(R.id.textView2)

        val btnGoToActivity2 = findViewById<Button>(R.id.button)
        btnGoToActivity2.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

        val btnGoToActivity3 = findViewById<Button>(R.id.button2)
        btnGoToActivity3.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }

        val count = findViewById<Button>(R.id.button3)
        count.setOnClickListener {
            val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
            val current = prefs.getInt("COUNT", 0) + 1
            prefs.edit().putInt("COUNT", current).apply()
            st.text = current.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val current = prefs.getInt("COUNT", 0)
        st.text = current.toString()
    }
}