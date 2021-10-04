package com.example.myviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    /*
    Dengan menambahkan turunan kelas ViewModel ke kelas MainViewModel, itu menandakan bahwa kelas
    tersebut menjadi kelas ViewModel. Segala sesuatu yang ada di kelas tersebut akan terjaga
    selama Activity masih dalam keadaan aktif. Pada kelas MainViewModel, nilai dari result
    akan selalu dipertahankan selama MainViewModel masih terikat dengan Activity.
     */

    var result = 0

    fun calculate(width: String, height: String, length: String) {
        result = width.toInt() * height.toInt() * length.toInt()
    }
}