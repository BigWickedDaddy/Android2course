package com.itis.a1semitis


import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil

class SongDiffCallback(
    private var oldList: List<Song>,
    private var newList: List<Song>
) : DiffUtil.Callback() {


    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val diffBundle = Bundle()
        if (diffBundle.size() == 0) return null
        return diffBundle
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (newList[newItemPosition].title == oldList[oldItemPosition].title)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition] == oldList[oldItemPosition]
    }
}