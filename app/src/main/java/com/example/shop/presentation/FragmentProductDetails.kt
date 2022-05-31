package com.example.shop.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shop.R
import com.example.shop.domain.Product

//TODO: use ViewBinding for Fragments
class FragmentProductDetails : Fragment() {
    private val product: Product
        get() {
            TODO()
        }

    //TODO: use Navigation components to navigate from fragments
    //TODO: use Safe Args to pass arguments from fragment to fragment
    //Fragments cannot receive intents or have constructors. Old realisation without safe args
    //was to use "newInstance" template with fragment arguments
    companion object {
        private const val EXTRA_PRODUCT_ID = "EXTRA_PRODUCT_ID"

        fun newIntent(context: Context, creatureId: Int): Intent {
            val intent = Intent(context, FragmentProductDetails::class.java)
            intent.putExtra(EXTRA_PRODUCT_ID, creatureId)
            return intent
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false)
       }
}


