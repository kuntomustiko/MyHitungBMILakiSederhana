package com.minara.kirana.myhitungbmilakisederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHitung_main.setOnClickListener {

            // get data from input user
            val tinggi = edtTinggi_main.text.toString()
            val berat = edtBerat_main.text.toString()

            // cek inputan user
            if (berat.isNotEmpty() && tinggi.isNotEmpty()) {

                val convertBerat = berat.toDouble()
                val convertTinggi = tinggi.toDouble()

                val hasil = hitung(convertBerat, convertTinggi)

                showAlert("$hasil")
            } else{
                showAlert("gak boleh kosong")
            }

        }
    }

    // melakukan perhitungan bmi
    fun hitung(berat: Double, tinggi: Double): Double {
        val hasil = berat / (Math.pow((tinggi / 100), 2.0))
        return hasil
    }

    // menampilkan alert
    fun showAlert(msg:String){
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Hasil Berat Ideal")
        alert.setMessage(msg)
        alert.show()
    }
}
