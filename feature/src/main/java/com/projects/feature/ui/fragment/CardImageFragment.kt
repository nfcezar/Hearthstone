package com.projects.feature.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.projects.feature.R
import com.projects.feature.adapter.CardImageAdapter
import com.projects.feature.databinding.FragmentCardImageBinding
import com.projects.feature.ui.viewmodel.CardImageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardImageFragment : Fragment(R.layout.fragment_card_image) {

    private val viewModel: CardImageViewModel by viewModel()

    private lateinit var binding: FragmentCardImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.imageUrl.observe(viewLifecycleOwner) { image ->
            binding.recyclerViewContainerImage.apply {
                adapter = CardImageAdapter(
                    context,
                    image
                )
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
            }
        }
    }
}