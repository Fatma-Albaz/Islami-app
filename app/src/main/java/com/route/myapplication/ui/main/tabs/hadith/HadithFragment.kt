package com.route.myapplication.ui.main.tabs.hadith

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.route.myapplication.R
import com.route.myapplication.adapter.HadithAdapter
import com.route.myapplication.databinding.FragmentHadeethBinding
import com.route.myapplication.model.HadithDM
import com.route.myapplication.repository.HadithRepository
import com.route.myapplication.utils.HorizontalSpacingDecoration

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
        var instance1= HadithRepository(context)
        var ahadith = instance1.generateHadithList()
        setUpRecyclerView(ahadith)
    }

    private fun setUpRecyclerView(ahadith: MutableList<HadithDM>) {
        binding.hadithRecyclerView.adapter = HadithAdapter(ahadith)
        binding.hadithRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.hadithRecyclerView)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.carousel_item_spacing)
        val sidePadding = resources.getDimensionPixelSize(R.dimen.carousel_side_padding)
        binding.hadithRecyclerView.setPadding(sidePadding, 0, sidePadding, 0)
        binding.hadithRecyclerView.addItemDecoration(HorizontalSpacingDecoration(spacingInPixels))
        binding.hadithRecyclerView.clipToPadding = false
        binding.hadithRecyclerView.clipChildren = false
    }
}