package com.udacity.shoestore.ui.shoe_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.shoe_list.ShoesListViewModel
import kotlinx.android.synthetic.main.fragment_shoe_details.*


class ShoeDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel: ShoesListViewModel by activityViewModels()

        val binding: FragmentShoeDetailsBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_shoe_details,
                container,
                false
            )
        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel


        binding.cancelButton.setOnClickListener { navigateBackToListScreen() }


        binding.saveButton.setOnClickListener {
            viewModel.addShoe()
            navigateBackToListScreen()
        }


        return binding.root
    }

    private fun navigateBackToListScreen() {
        findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
    }
}