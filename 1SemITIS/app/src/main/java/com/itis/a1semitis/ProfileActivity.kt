package com.itis.a1semitis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itis.a1semitis.databinding.PersonProfileBinding

class ProfileActivity: AppCompatActivity() {

    private lateinit var binding: PersonProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PersonProfileBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        print(intent.extras?.getInt("id"))
        val id = intent.extras?.getInt("id")
        with(binding){
            val person = id?.let {
                PersonRepository.PersonId(id)
            }
            val name = person?.name
            val position = person?.position
            val description = person?.description

            person?.photo?.let {
                ivPhoto.setImageResource(it)
                tvNameprofile.text = "Person Name: $name"
                tvPositionofperson.text = "His position: $position"
                tvDescriptionProfile.text = "Description: $description"
            }
        }
    }
}