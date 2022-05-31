package com.example.shop.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shop.databinding.FragmentProductFeedBinding

class FragmentProductFeed : Fragment() {
    private lateinit var layoutManager: StaggeredGridLayoutManager

    private var gridState = GridState.GRID
    private var _binding: FragmentProductFeedBinding? = null
    private val binding get() = _binding!!

    private enum class GridState {
        LIST, GRID
    }


    //TODO: use Navigation component to navigate from fragments
    companion object {
        fun newInstance(): FragmentProductFeed {
            return FragmentProductFeed()
        }
    }

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
    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)

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