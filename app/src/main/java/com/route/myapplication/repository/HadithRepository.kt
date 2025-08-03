package com.route.myapplication.repository

import android.content.Context
import android.util.Log
import com.route.myapplication.model.HadithDM
import java.io.InputStream

class HadithRepository(private var context: Context?) {
    private var hadithDMs = mutableListOf<HadithDM>()
    private fun readHadithFileContent(): InputStream? {
        return context?.assets?.open("hadith/ahadeth .txt")

    }

    fun generateHadithList(): MutableList<HadithDM> {
        val inputStream = readHadithFileContent()
        var title = ""
        val hadithContent: StringBuilder = java.lang.StringBuilder()
        val fileReader = inputStream?.bufferedReader()
        var fileLine = fileReader?.readLine()
        while (fileLine != null) {
            var titleAdded = false
            title =""
            hadithContent.clear()
            while (fileLine!= null && fileLine.trim() != "#") {
                if (!titleAdded) {
                    title = fileLine
                    titleAdded = true
                } else {
                    hadithContent.append(fileLine)
                }
                fileLine = fileReader?.readLine()
            }
            hadithDMs.add(HadithDM(title, hadithContent.toString()))
            fileLine = fileReader?.readLine()
        }
        return hadithDMs
    }
}