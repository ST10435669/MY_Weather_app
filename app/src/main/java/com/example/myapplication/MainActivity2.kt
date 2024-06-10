package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val day = findViewById<EditText>(R.id.day)
        val min = findViewById<EditText>(R.id.min)
        val max = findViewById<EditText>(R.id.max)
        val condition = findViewById<EditText>(R.id.condition)
        val enter = findViewById<Button>(R.id.enter)

        enter.setOnClickListener {
            val weatherInfo = WeatherInfo(day.text.toString(), min.text.toString(), max.text.toString(), condition.text.toString())
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("weatherInfo", weatherInfo as Serializable)
            startActivity(intent)
        }

        val ms = findViewById<Button>(R.id.ds)
        ms.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        val exit = findViewById<Button>(R.id.exit2)
        exit.setOnClickListener {
            finish()
        }
    }
}