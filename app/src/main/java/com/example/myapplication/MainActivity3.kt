package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val extras = intent.extras
        val weatherInfo = extras?.getSerializable("weatherInfo") as? WeatherInfo

        val tableLayout = findViewById<TableLayout>(R.id.table)

        for (i in 1 until tableLayout.childCount) { // start from 1 to skip the header row
            val row = tableLayout.getChildAt(i) as TableRow
            val dayTextView = row.getChildAt(0) as TextView
            if (dayTextView.text.toString() == weatherInfo?.day) {
                val minTextView = TextView(this)
                val maxTextView = TextView(this)
                val conditionTextView = TextView(this)
                minTextView.text = weatherInfo.min
                maxTextView.text = weatherInfo.max
                conditionTextView.text = weatherInfo.condition
                row.addView(minTextView)
                row.addView(maxTextView)
                row.addView(conditionTextView)
                break
            }
        }

        val ms2 = findViewById<Button>(R.id.ms2)
        ms2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}