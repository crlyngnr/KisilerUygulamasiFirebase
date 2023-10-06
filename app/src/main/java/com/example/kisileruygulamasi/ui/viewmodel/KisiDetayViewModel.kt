package com.example.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor(var kRepo : KisilerRepository) : ViewModel() {
    fun kisiGuncelle(kisi_id: String,kisi_ad : String,  kisi_tel: String){
            kRepo.kisiGuncelle(kisi_id,kisi_ad,kisi_tel)
    }
}