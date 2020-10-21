package com.example.nativeapps;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.nativeapps.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val arguments: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.person = Person(arguments.firstName, arguments.lastName)

        return binding.root
    }
}