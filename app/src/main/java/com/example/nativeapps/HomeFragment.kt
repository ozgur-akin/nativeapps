package com.example.nativeapps;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nativeapps.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.setNavigateClickListener {
            navigateToDetailFragment()
        }

        return binding.root

    }

    private fun navigateToDetailFragment(){
        viewModel.person.value?.let {
            val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.firstName, it.lastName)
            findNavController().navigate(directions)
        }
    }
}