package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContex : Context, var kisilerListesi: List<Kisiler>, var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardViewHolder>() {

    inner class CardViewHolder(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding : CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContex),R.layout.card_tasarim,parent,false)
        return CardViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim
        t.kisiNesnesi = kisi
        t.cardViewKisi.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener{
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi ?",Snackbar.LENGTH_SHORT).setAction("EVET"){
                viewModel.kisiSil(kisi.kisi_id!!)
            }.show()
        }
    }
    override fun getItemCount(): Int {
        return kisilerListesi.size
    }
}