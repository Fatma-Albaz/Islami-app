package com.route.myapplication.ui.main.tabs.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.myapplication.databinding.FragmentSebhaBinding
import com.route.myapplication.repository.SebhaRepository

class SebhaFragment:Fragment() {
    private lateinit var binding: FragmentSebhaBinding
    private var displayedTasbehIndex=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sebhaList = SebhaRepository (context).generateTasabehList()
        setupViews(sebhaList)
        setupListeners(sebhaList)
    }

    private fun setupViews(sebhaList: MutableList<String>) {
        binding.tasbehaName.text = sebhaList[displayedTasbehIndex]
        binding.tasbehaNumber.text = "0"
    }

    private fun setupListeners(sebhaList: MutableList<String>) {
        binding.btnSebha.setOnClickListener{
            val tasbehNumber = Integer.parseInt(binding.tasbehaNumber.text.toString())+1
            binding.tasbehaNumber.text = tasbehNumber.toString()
            it.animate()
                .rotation(it.rotation + 11f)
                .setDuration(300)
                .start()
            if (tasbehNumber% 33 == 0){
                displayedTasbehIndex++
                if (displayedTasbehIndex>=sebhaList.size){
                    displayedTasbehIndex=0
                }
                binding.tasbehaName.text = sebhaList[displayedTasbehIndex]
            }
        }
    }
}