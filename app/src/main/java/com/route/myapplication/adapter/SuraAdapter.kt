package com.route.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.myapplication.databinding.ItemAyaBinding

class SuraAdapter(private val list: MutableList<String>):Adapter<SuraAdapter.SuraViewHolder> (){
    private lateinit var binding: ItemAyaBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraViewHolder {
        binding = ItemAyaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SuraViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SuraViewHolder, position: Int) {
        holder.bindSura(list[position], position)
    }


    inner class SuraViewHolder(private val itemAyaBinding: ItemAyaBinding) : ViewHolder(itemAyaBinding.root){
        fun bindSura(suraContent:String, position: Int){
            itemAyaBinding.ayaContentTv.text = suraContent
            (position+1).toString().also { itemAyaBinding.numOfAya.text = it }
        }
    }
}