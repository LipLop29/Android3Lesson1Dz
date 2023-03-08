package com.example.android3lesson1dz.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.android3lesson1dz.data.model.GeneralModel
import com.example.android3lesson1dz.ui.adaptetr.GeneralAdapter
import com.example.android3lesson1dz.ui.viewmodels.MainFragmentViewModel
import com.example.android3lesson1dz.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var viewModel: MainFragmentViewModel? = null
    private var listCat = mutableListOf<GeneralModel>()
    private var generalAdapter = GeneralAdapter(this::onItemClick,listCat)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        initialize()
        setupList()
    }

    private fun initialize() {
        viewModel?.let { listCat.addAll(it.getListOfCatHTP()) }
        binding.recycler.adapter = generalAdapter
    }

    private fun setupList() {
        binding.btnShow.setOnClickListener {
            binding.recycler.isVisible = true
            binding.btnShow.isVisible = false
            binding.tvText.isVisible = false
        }
    }

    private fun onItemClick(generalModel: GeneralModel) {
        val action: NavDirections =
            MainFragmentDirections.actionMainFragmentToDetailFragment(
                generalModel.name,
                generalModel.img
            )
        findNavController().navigate(action)
    }
}