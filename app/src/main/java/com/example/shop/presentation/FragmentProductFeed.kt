package com.example.shop.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shop.R
import com.example.shop.databinding.FragmentProductFeedBinding

class FragmentProductFeed : Fragment() {
    private var _binding: FragmentProductFeedBinding? = null
    private val binding get() = _binding!!

    //TODO: use Navigation component to navigate from fragments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductFeedBinding.inflate(inflater, container, false)
        return binding.root
    }


    //TODO: start with default LinearLayoutManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.binding.apply {

            toolbarBack.isVisible = false

            toolbarFavorite.setOnClickListener {

                binding.toolbar.setOnFavoriteClickListener {

                    toolbarUser.isVisible = false
                    toolbarBack.isVisible = true
                    toolbarFavorite.isActivated = true

                    findNavController().navigate(R.id.action_fragmentProductFeed_to_fragmentFavorites)
                }
            }
        }

        binding.apply {
            lineButton.isActivated = true

            lineButton.setOnClickListener {
                lineButton.isActivated = true
                gridButton.isActivated = false
            }

            gridButton.setOnClickListener {
                lineButton.isActivated = false
                gridButton.isActivated = true

            }
        }


    }
}