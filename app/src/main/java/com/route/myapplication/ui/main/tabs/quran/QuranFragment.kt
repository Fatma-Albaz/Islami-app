package com.route.myapplication.ui.main.tabs.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.route.myapplication.adapter.QuranAdapter
import com.route.myapplication.databinding.FragmentQuranBinding
import com.route.myapplication.repository.SuraRepository
import com.route.myapplication.ui.main.home.SuraDetailsActivity
import com.route.myapplication.utils.Constants

class QuranFragment : Fragment() {
    private lateinit var binding: FragmentQuranBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View{
        // Inflate the layout for this fragment
        binding = FragmentQuranBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.suraRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.suraRecyclerView.adapter = QuranAdapter(SuraRepository.generateSuraList(),{
            selectedSura ->
            var intent = Intent (context, SuraDetailsActivity::class.java)
            intent.putExtra(Constants.SURA_DETAILS,selectedSura)
            startActivity(intent)
        })
    }
}