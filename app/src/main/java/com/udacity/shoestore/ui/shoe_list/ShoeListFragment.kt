package com.udacity.shoestore.ui.shoe_list

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    val viewModel: ShoesListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        setHasOptionsMenu(true)

        val binding: FragmentShoeListBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_shoe_list,
                container,
                false
            )


        binding.addFab.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }



        viewModel.shoes.observe(viewLifecycleOwner) { shoeList ->

            shoeList.forEach { shoe ->

                val listItemBinding: ShoeListItemBinding =
                    DataBindingUtil.inflate(
                        inflater,
                        R.layout.shoe_list_item,
                        binding.scrollView,
                        false
                    )

                listItemBinding.shoe = shoe
                binding.shoeList.addView(listItemBinding.shoeItemCard)
            }

        }


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        viewModel.clearList()
        return true

    }
}