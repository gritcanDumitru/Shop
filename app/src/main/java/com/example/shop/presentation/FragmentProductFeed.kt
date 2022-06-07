package com.example.shop.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.databinding.FragmentProductFeedBinding
import com.example.shop.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentProductFeed : Fragment() {

    private var myAdapter = ProductAdapter { productModel, state ->
        //add to favourites
    }

    private var _binding: FragmentProductFeedBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FeedViewModel>()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            productsRecyclerView.addItemDecoration(DividerItemDecoration(context, OrientationHelper.VERTICAL))
            productsRecyclerView.layoutManager = LinearLayoutManager(context)
            productsRecyclerView.adapter = myAdapter

        }


        binding.productsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                myAdapter.scrollDirection = if (dy > 0) {
                    ProductAdapter.ScrollDirection.DOWN
                } else {
                    ProductAdapter.ScrollDirection.UP
                }
            }
        })

        viewModel.items.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Failed -> showException(result.exception)
                is Result.Success -> myAdapter.submitList(result.data)
            }
        }

        viewModel.getProducts()

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


    private fun showException(exception: Exception) {
        TODO("Not yet implemented")
    }
}