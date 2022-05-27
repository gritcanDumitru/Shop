package com.example.shop.Presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.databinding.FragmentProductFeedBinding

class FragmentProductFeed : Fragment() {

//    private val adapter = ProductsListAdapter(ProductStore.getProduct())

    private var _binding: FragmentProductFeedBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance(): FragmentProductFeed {
            return FragmentProductFeed()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentProductFeedBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            productsRecyclerView.layoutManager = LinearLayoutManager(activity)
//            productsRecyclerView.adapter = adapter
        }
    }
}