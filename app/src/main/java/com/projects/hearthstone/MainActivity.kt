package com.projects.hearthstone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.projects.feature.FragmentClickListener
import com.projects.feature.ui.fragment.CardImageFragment
import com.projects.feature.ui.fragment.HomeFragment
import com.projects.hearthstone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()

        if (savedInstanceState == null) {
            homeFragment.setFragmentClickListener(this)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, homeFragment)
                .addToBackStack("")
                .setReorderingAllowed(true)
                .commit()
        }
    }

    override fun onFragmentButtonClick() {
        val cardImageFragment = CardImageFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_fragment, cardImageFragment)
            .commit()
    }
}

