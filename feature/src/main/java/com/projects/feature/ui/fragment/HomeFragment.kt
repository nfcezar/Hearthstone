package com.projects.feature.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.projects.feature.FragmentClickListener
import com.projects.feature.R
import com.projects.feature.adapter.HomeClassAdapter
import com.projects.feature.adapter.HomeRaceAdapter
import com.projects.feature.adapter.HomeTypeAdapter
import com.projects.feature.databinding.FragmentHomeBinding
import com.projects.feature.ui.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()

    private lateinit var binding: FragmentHomeBinding

    private var clickListener: FragmentClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.classNameList.observe(viewLifecycleOwner) {
            binding.cardCategoryName.text = it.title
            binding.homeRecyclerView.apply {
                adapter = HomeClassAdapter(it.cards) {
                    clickListener?.onFragmentButtonClick()
                }
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            }
        }

        viewModel.raceListNames.observe(viewLifecycleOwner) {
            binding.cardCategoryRaces.text = it.title
            binding.homeRecyclerViewRace.apply {
                adapter = HomeRaceAdapter(it.cards) {
                    clickListener?.onFragmentButtonClick()
                }
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            }
        }

        viewModel.typeListNames.observe(viewLifecycleOwner) {
            binding.cardCategoryTypes.text = it.title
            binding.homeRecyclerViewType.apply {
                adapter = HomeTypeAdapter(it.cards) {
                    clickListener?.onFragmentButtonClick()
                }
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            }
        }
    }

    fun setFragmentClickListener(listener: FragmentClickListener) {
        clickListener = listener
    }
}