package com.itis.a1semitis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.itis.a1semitis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        with(binding) {
            btnLeft.setOnClickListener{
                AnotherFragment(FirstF())
            }

            btnMiddle.setOnClickListener{
                AnotherFragment(SecondF())
            }

            btnRight.setOnClickListener{
                AnotherFragment(ThirdF())
            }
        }

    }

    private fun AnotherFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.right, R.anim.right_back, R.anim.left, R.anim.left_back)
            .replace(R.id.fragment_container_view_tag, fragment)
            .addToBackStack(null)
            .commit()
    }

}
