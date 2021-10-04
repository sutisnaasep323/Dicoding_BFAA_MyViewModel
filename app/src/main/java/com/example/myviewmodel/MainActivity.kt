package com.example.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    //    private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels() // menyaingkat kode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        // menyambungkan kelas MainViewModel dengan MainActivity
        /*
        Ketika Activity membutuhkan ViewModel, Anda cukup memanggil kelas ViewModelProvider dengan
        parameter context. Karena inisialisasi dilakukan di Activity, maka kita menggunakan this
        sebagai context. Kemudian input .get() diisi dengan kelas ViewModel mana yang akan
        dihubungkan dengan Activity
         */
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        displayResult()
        activityMainBinding.btnCalculate.setOnClickListener {
            val width = activityMainBinding.edtWidth.text.toString()
            val height = activityMainBinding.edtHeight.text.toString()
            val length = activityMainBinding.edtLength.text.toString()
            when {
                width.isEmpty() -> {
                    activityMainBinding.edtWidth.error = "Masih kosong"
                }
                height.isEmpty() -> {
                    activityMainBinding.edtHeight.error = "Masih kosong"
                }
                length.isEmpty() -> {
                    activityMainBinding.edtLength.error = "Masih kosong"
                }
                else -> {
                    /*
                    input
                    metode calculate yang berfungsi untuk melakukan perkalian dari input lebar, panjang dan tinggi
                     */
                    viewModel.calculate(width, height, length)
                    /*
                    setiap perubahan dari result tidak bisa secara otomatis terganti. Anda perlu
                    memanggil metode displayResult() untuk memperbarui nilai result. Hal ini karena
                    Anda belum menggunakan LiveData yang bisa otomatis memperbarui teks ketika ada perubahan data
                     */
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() { // memperbarui nilai result
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}