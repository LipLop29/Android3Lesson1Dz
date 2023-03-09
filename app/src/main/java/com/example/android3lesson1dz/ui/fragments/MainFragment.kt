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
import com.example.android3lesson1dz.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var viewModel: MainFragmentViewModel? = null
    private var generalAdapter = GeneralAdapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupList()
        setupObserves()
    }

    private fun initialize() {
        binding.recycler.adapter = generalAdapter
    }

    private fun setupList() {
        binding.btnShow.setOnClickListener {
            binding.recycler.isVisible = true
            binding.btnShow.isVisible = false
            binding.tvText.isVisible = false
        }
    }

    private fun setupObserves() {
        viewModel?.getListOfCatHTP()?.observe(viewLifecycleOwner) {
            generalAdapter.setList(it)
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