package com.route.myapplication.repository

import android.content.Context

class SebhaRepository (var context: Context?){
    private var tasabehList = mutableListOf <String> ()
    fun generateTasabehList () : MutableList <String>{
        val inputStream= context?.assets?.open("sebha/tasbeh.txt")
        val fileReader = inputStream?.bufferedReader()
        var fileLine = fileReader?.readLine()
        while (fileLine!= null){
            if (fileLine.trim()!="#"){
                tasabehList.add(fileLine)
            }
            fileLine = fileReader?.readLine()
        }
        return tasabehList
    }
}