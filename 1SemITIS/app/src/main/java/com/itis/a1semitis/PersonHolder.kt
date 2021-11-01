package com.itis.a1semitis

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.itis.a1semitis.databinding.ItemPersonBinding

class PersonHolder (
    item: View
) : RecyclerView.ViewHolder(item) {

    private var person: Person? = null
    val binding = ItemPersonBinding.bind(item)

    fun bind(item: Person) {
        this.person = item
        with(binding) {
            tvName.text = item.name
            tvBreed.text = item.position
            ivImage.setImageResource(item.photo)
        }

        itemView.setOnClickListener {
            val context = itemView.context
            val intent = Intent(context,ProfileActivity::class.java)
            intent.putExtra("id", item.id)
            print(item.id)
            context.startActivity(intent)
        }
    }
}