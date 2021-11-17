package com.itis.a1semitis

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.itis.a1semitis.databinding.FragmentSecondBinding
/*
import com.itis.a1semitis.dopBalli.SwipeToDeleteCallbackImpl
*/
import com.itis.a1semitis.databinding.DialogWindowBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var bindingOfDialog: DialogWindowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val elements = (requireActivity() as MainActivity).people
        val allPictures = (requireActivity() as MainActivity).pictures
        init(PersonAdapter(elements))
        binding.btnAddPerson.setOnClickListener {
            val alert = AlertDialog.Builder(context).apply {
                bindingOfDialog = DialogWindowBinding.inflate(LayoutInflater.from(context))
                setView(bindingOfDialog.root)
            }.show()
            bindingOfDialog.btnYes.setOnClickListener {
                var id = 0
                try {
                    id = bindingOfDialog.vtPosition.text.toString().toInt()
                } catch (e: Exception) {}
                val pictures = ArrayList<Int>()
                for (i in 1..((2 until 10).random())) {
                    pictures.add(allPictures[(0 until allPictures.size).random()])
                }
                val element = Person(
                    id,
                    bindingOfDialog.vtName.text.toString(),
                    bindingOfDialog.vtDescription.text.toString(),
                    pictures
                )
                if (id - 1 >= elements.size || id <= 0) {
                    (requireActivity() as MainActivity).people.add(element)
                    element.id = (requireActivity() as MainActivity).people.size + 1
                } else {
                    (requireActivity() as MainActivity).people
                        .add(id - 1, element)
                }
                init(PersonAdapter((requireActivity() as MainActivity).people))
                alert.dismiss()
            }
            bindingOfDialog.btnNo.setOnClickListener {
                alert.dismiss()
            }
        }
    }

    private fun init(adapter: PersonAdapter) {
        binding.apply {
            rwFirst.layoutManager = LinearLayoutManager(requireActivity()).apply {
                orientation = RecyclerView.VERTICAL
            }
            /*context?.let {
                SwipeToDeleteCallbackImpl((requireActivity() as MainActivity).people, it, binding)
            }?.let {
                ItemTouchHelper(it).attachToRecyclerView(binding.listOne)
            }*/
            rwFirst.addItemDecoration(ItemDecorator(16, 8))
            rwFirst.adapter = adapter
        }
    }
}