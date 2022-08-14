package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)
        binding.loginButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.signupButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        return binding.root
    }

}