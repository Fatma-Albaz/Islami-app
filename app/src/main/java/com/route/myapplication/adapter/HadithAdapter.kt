package com.route.myapplication.adapter

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.myapplication.databinding.ItemHadithBinding
import com.route.myapplication.model.HadithDM

class HadithAdapter (private var hadithList: MutableList<HadithDM>): Adapter<HadithAdapter.HadithViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithViewHolder {
        val binding = ItemHadithBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HadithViewHolder(binding)
    }
    override fun onBindViewHolder(holder: HadithViewHolder, position: Int) {
       holder.bindHadith(hadithList[position])
    }
    override fun getItemCount(): Int = hadithList.size


    inner class HadithViewHolder(val binding: ItemHadithBinding): ViewHolder (binding.root){
        fun bindHadith(hadithDm: HadithDM){
            binding.hadithTitleTv.text = hadithDm.hadithTitle
            binding.hadithContentTv.text = hadithDm.hadithContent
            binding.hadithContentTv.movementMethod = ScrollingMovementMethod()
        }
    }
}