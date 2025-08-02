package com.route.myapplication.ui.main.tabs.hadith

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.myapplication.databinding.FragmentHadeethBinding

class HadithFragment : Fragment() {

    private lateinit var binding: FragmentHadeethBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadeethBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}