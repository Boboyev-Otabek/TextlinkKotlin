package com.example.textlinkkotlin

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var textmain:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        textmain = findViewById<TextView>(R.id.text)
        val text = "I would like to do something similar to the https://twitter.com app"
        val spannable: Spannable = SpannableString(text)
        val i1 = text.indexOf("https://")
        var i2: Int
        val arr = text.split(" ").toTypedArray()
        for (item in arr) {
            if (item.startsWith("https://")) {
                i2 = item.length + i1
                spannable.setSpan(
                    ForegroundColorSpan(Color.BLUE),
                    i1,
                    i2,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        textmain.setText(spannable)
    }
}