package com.example.kisileruygulamasi.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.entity.Kisiler

class KisilerRepository(var kds : KisilerDataSource) {
    fun kisiKaydet(kisi_ad : String,  kisi_tel: String) = kds.kisiKaydet(kisi_ad,kisi_tel)
    fun kisiGuncelle(kisi_id: String, kisi_ad: String, kisi_tel: String) = kds.kisiGuncelle(kisi_id,kisi_ad,kisi_tel)
    fun kisiSil(kisi_id : String) = kds.kisiSil(kisi_id)
    fun kisileriYukle() : MutableLiveData<List<Kisiler>> =kds.kisileriYukle()
    fun kisiAra(aramaKelimesi : String): MutableLiveData<List<Kisiler>> = kds.kisiAra(aramaKelimesi)
}