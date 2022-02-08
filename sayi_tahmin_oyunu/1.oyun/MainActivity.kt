package com.example.myapplicationsayit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*


class MainActivity : AppCompatActivity() {

    private var deneme = 1
    private var sayi = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sayibelirle()
    }

    fun button_click(view: View) {
        val edtTahmin = findViewById<EditText>(R.id.editText2)
        val txtSonuc = findViewById<TextView>(R.id.textView3)
        val txtTahmin = findViewById<TextView>(R.id.textView)

        if (edtTahmin.text.toString().toInt() == sayi)
        {
            txtSonuc.text = "Doğru Tahmin : $sayi"
        }
        else
        {
            //Toast.makeText(this, "Yanlış Tahmin, sayı: $sayi", Toast.LENGTH_SHORT).show()
            txtSonuc.text = "Yanlış Tahmin. Tekrar Deneyin..."
            deneme++
            txtTahmin.text = "$deneme. denemeniz :"

        }
    }

    fun sayibelirle(){
        val r = Random()
        sayi = r.nextInt(10)
    }
}
