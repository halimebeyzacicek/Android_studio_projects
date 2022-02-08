package com.example.sayitahminoyunu

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var deneme = 1
    private var sayi = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sayiBelirle()
    }
    fun button_click(view: View){
        val edtTahmin= findViewById<TextView>(R.id.number)
        val txtSonuc=findViewById<TextView>(R.id.sonuc)
        val txtTahmin=findViewById<TextView>(R.id.tahmin)

        if (edtTahmin.text.toString().toInt()==sayi){
            txtSonuc.text="Doğru Tahmin:$sayi"
            butonyeni.setOnClickListener{
                sayiBelirle()      ///yeni oyun için
                deneme = 1
                txtTahmin.text="$deneme. denemeniz:"
            }

        }
        else{
            if(edtTahmin.text.toString().toInt()<sayi){
                txtSonuc.text="Tahmininiz Sayi'dan küçük.Tekrar Deneyiniz..."
                deneme++
                txtTahmin.text="$deneme. denemeniz:"
            }
            else{
                txtSonuc.text="Tahmininiz Sayi'dan büyük.Tekrar Deneyiniz..."
                deneme++
                txtTahmin.text="$deneme. denemeniz:"
            }
            /*txtSonuc.text="Yanliş Tahmin!Tekrar deneyiniz..."
            deneme++
            txtTahmin.text="$deneme. denemeniz:"*/

        }
    }

    fun sayiBelirle(){
        val r= Random()
        sayi=r.nextInt(10)
    }
}



