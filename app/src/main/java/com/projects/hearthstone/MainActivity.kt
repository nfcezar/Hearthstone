package com.projects.hearthstone

import android.os.Bundle
import android.view.View
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

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.toolbarTitle.text = "Hearthstone"
        binding.toolbarBackBtn.visibility = View.GONE
        binding.toolbarCategoryName.visibility = View.GONE

        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }

        homeFragment.setFragmentClickListener(this)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_fragment, homeFragment)
            .commit()

        /*        binding.toolbarTitle.visibility = View.GONE
                binding.toolbar.apply {
                    navigationIcon = getDrawable(com.projects.feature.R.drawable.baseline_arrow_back_ios_24)
                }*/
    }

    override fun onFragmentButtonClick() {
        val cardImageFragment = CardImageFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_fragment, cardImageFragment)
            .commit()
    }
}

