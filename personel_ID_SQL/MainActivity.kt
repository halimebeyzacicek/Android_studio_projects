package com.example.finaltek

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Uygulama calistirildiginda DB, Tablo ve Kayitlarin olusturulmasi
        //dbOlustur()
    }

    fun btnBulClick(view: View){
        // BUL butonuna tiklandiginda girilen ID'li personelin bilgilerini textView'lara yazan kodu tamamlayiniz...
        val db = openOrCreateDatabase("finaldb", Context.MODE_PRIVATE,null)
        val sorgu = "SELECT * FROM personel WHERE _id LIKE \'${editTextID.text}%\'"
        Log.d("SORGU",sorgu)
        val cr = db.rawQuery(sorgu,null)
        var sonuclistesi1 =""
        var sonuclistesi2 =""
        var sonuclistesi3 =""
        var sonuclistesi4 =""
        if (cr.count==1) {
            while (cr.moveToNext()) {  //ilk kayıda konumlanabilirim.
                val ucret = cr.getInt(cr.getColumnIndex("ucret"))
                val isim = cr.getString(cr.getColumnIndex("ad"))
                val soyisim = cr.getString(cr.getColumnIndex("soyad"))
                val brm = cr.getString(cr.getColumnIndex("birim"))
                sonuclistesi1 += "$isim"
                sonuclistesi2 += "$soyisim"
                sonuclistesi3 += "$brm"
                sonuclistesi4 += "${ucret.toString()}"
            }
            textViewAd.text =sonuclistesi1
            textViewSoyad.text=sonuclistesi2
            textViewBirim.text=sonuclistesi3
            textViewUcret.text=sonuclistesi4
        } else {
            Toast.makeText(this,"Belirtilen ID'li Personel Bulunamadı!",Toast.LENGTH_LONG).show()
        }
    }

    fun dbOlustur(){

        // finaldb veritabaninin olusturulmasi
        val db = openOrCreateDatabase("finaldb", Context.MODE_PRIVATE,null)

        // Personel tablosu daha onceden olusturulmus mu kontrolu
        val tablokontrol = db.rawQuery("SELECT DISTINCT tbl_name from sqlite_master WHERE tbl_name = 'personel'", null)

        if (tablokontrol.count < 1) {

            //Tablonun olusturulmasi ve ornek kayitlarin eklenmesi
            val sc = Scanner(resources.openRawResource(R.raw.personel))

            while (sc.hasNextLine()) {
                val sorgu = sc.nextLine()
                db.execSQL(sorgu)
            }
        }

        tablokontrol.close()
        db.close()
    }
}
