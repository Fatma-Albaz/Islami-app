package com.route.myapplication.ui.main.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.route.myapplication.adapter.SuraAdapter
import com.route.myapplication.databinding.ActivitySuraDetailsBinding
import com.route.myapplication.model.QuranDM
import com.route.myapplication.utils.Constants

class SuraDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sura = intent?.getParcelableExtra<QuranDM>(Constants.SURA_DETAILS)
        setupViews(sura)
        setupListeners()
        setupRecyclerView(sura)
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun readSuraContentAssets(sura: QuranDM?):MutableList<String> {
        val inputStream = assets.open("quran/${sura?.suraNumber}.txt")
        val data =inputStream.bufferedReader().readText()
        return data.trim().split("\n").toMutableList()
    }

    private fun setupViews(sura: QuranDM?) {
        binding.suraArabicTitle.text = sura?.suraArabicTitle
        binding.suraEnglishTitle.text = sura?.suraEnglishTitle
    }

    private fun setupRecyclerView( sura: QuranDM?) {
        binding.suraRecyclerView.layoutManager= LinearLayoutManager (this,LinearLayoutManager.VERTICAL,false)
        binding.suraRecyclerView.adapter = SuraAdapter(readSuraContentAssets(sura))
    }
}