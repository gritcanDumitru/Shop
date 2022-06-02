package com.example.shop.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shop.R
import com.example.shop.databinding.FragmentFavoritesBinding

class FragmentFavorites : Fragment() {
    private var _binding: FragmentFavoritesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO: change toolbar interfaces logic
        //You need to provide to yourself a couple of functions, that you will use to configure a
        //toolbar, like [toolbar.setOnBackClickListener], do not apply something on binding directly
        //if it is not necessary
        binding.toolbar.binding.apply {

            toolbarUser.isVisible = false
            toolbarFavorite.isActivated = true

            toolbarBack.setOnClickListener {

                binding.toolbar.setOnBackClickListener {

                    toolbarUser.isVisible = true
                    toolbarBack.isVisible = false
                    toolbarFavorite.isActivated = false

                    findNavController().navigate(R.id.action_fragmentFavorites_to_fragmentProductFeed)

                }
            }
        }
    }

}
