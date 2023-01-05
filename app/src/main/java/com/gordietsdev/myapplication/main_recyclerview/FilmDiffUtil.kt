package com.gordietsdev.myapplication.main_recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.gordietsdev.myapplication.main_recyclerview.Film

class FilmDiffUtil(private val oldList: List<Film>, private val newList: List<Film>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title &&
        oldList[oldItemPosition].poster == newList[newItemPosition].poster &&
        oldList[oldItemPosition].description == newList[newItemPosition].description
    }
}