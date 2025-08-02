package com.route.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.myapplication.databinding.ItemSuraBinding
import com.route.myapplication.model.QuranDM

class QuranAdapter(private val listOfSura:List<QuranDM>,
    val onSuraClick: (selectedSura:QuranDM)->Unit): RecyclerView.Adapter<QuranAdapter.QuranViewHolder>() {
    private lateinit var binding: ItemSuraBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        binding = ItemSuraBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuranViewHolder(binding)
    }
    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        holder.bind(listOfSura[position])
    }

    override fun getItemCount(): Int = listOfSura.size


    inner class QuranViewHolder(private var itemBinding: ItemSuraBinding): ViewHolder(itemBinding.root) {
        fun bind (currentSura: QuranDM){
            itemBinding.root.setOnClickListener {
                onSuraClick(currentSura)
            }
            itemBinding.suraArabicTitle.text = currentSura.suraArabicTitle
            itemBinding.suraEnglishTitle.text = currentSura.suraEnglishTitle
            itemBinding.numOfAya.text = buildString {
                append(currentSura.suraVersesNumber)
                append(" Verses")
            }
            itemBinding.suraNumber.text = currentSura.suraNumber
        }
    }
}