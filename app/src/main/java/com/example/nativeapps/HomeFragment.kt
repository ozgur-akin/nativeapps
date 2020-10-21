package com.example.nativeapps;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nativeapps.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var person: Person? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.setClickListener {
            person = Person("Elena", "Gilbert")
            binding.person = person
        }

        binding.setNavigateClickListener {
            navigateToDetailFragment()
        }

        return binding.root

    }

    private fun navigateToDetailFragment(){
        person?.let {
            val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.firstName, it.lastName)
            findNavController().navigate(directions)
        }
    }
}