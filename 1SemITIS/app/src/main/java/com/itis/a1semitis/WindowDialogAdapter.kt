package com.itis.a1semitis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itis.a1semitis.databinding.BlancPageBinding

class WindowDialogAdapter(private var pictures: ArrayList<Int>):
    RecyclerView.Adapter<WindowDialogAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(
        private val binding: BlancPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(id: Int) = binding.picture.setImageResource(id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder =
        ViewPagerViewHolder(
            BlancPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(pictures[position])
    }

    override fun getItemCount(): Int = pictures.size
}