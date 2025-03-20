package com.test.qolami.viewnodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.qolami.R
import com.test.qolami.view.pelajaran.data.DataPelajaranKata
import com.test.qolami.view.pelajaran.data.DataPelajaranKataDetail

class PelajaranKataViewModel:ViewModel() {
    val listData = arrayListOf(
        DataPelajaranKata(R.drawable.ic_pelajaran_kata1,"Pelajaran 1", "Kata berakhiran fathah, kasrah, dammah")
    )
    val getDataKata : MutableLiveData<List<DataPelajaranKata>> = MutableLiveData()
    fun getData(){
        getDataKata.value = listData
    }
    val listDataDetail = arrayListOf(
        DataPelajaranKataDetail("Pelajaran 1", R.drawable.ic_pelajaran_kata1, "Pelajaran 1", "Kata Berakhiran Fathah, Kasrah, Dhammah", "Mempelajari Kata yang berakhiran Fathah, kasrah, Dhamnmah")
    )
    val getDataKataDetail : MutableLiveData<List<DataPelajaranKataDetail>> = MutableLiveData()
    fun getDataDetail(){
        getDataKataDetail.value = listDataDetail
    }
}