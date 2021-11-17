package com.itis.a1semitis

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import com.itis.a1semitis.databinding.ViewFirstBinding

class PersonAdapter(people: List<Person>): RecyclerView.Adapter<PersonAdapter.PersonHolder>() {

    private var people: List<Person>? = people

    inner class PersonHolder(
        private val binding: ViewFirstBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Person) = with(binding) {
            nameOfPerson.text = item.name
            personDescription.text = item.description
            viewPager2.adapter = WindowDialogAdapter(item.pictures)
            position.text = "Позиция: ${(people?.indexOf(item))?.plus(1)}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder =
        PersonHolder(
            ViewFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        people?.get(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        people?.let {
            return it.size
        }
        return 0
    }
}