package com.route.banksystemapplication.ui.homescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.route.banksystemapplication.R
import com.route.banksystemapplication.databinding.FragmentHomeScreenBinding
import com.route.banksystemapplication.ui.allusers.AllUsers


class home_screen : Fragment() {
   lateinit var viewModel : HomeScreenViewModel
   lateinit var binding:FragmentHomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         inflater.inflate(R.layout.fragment_home_screen, container, false)
        binding= FragmentHomeScreenBinding.inflate(inflater)
        viewModel= ViewModelProvider(this)[HomeScreenViewModel::class.java]


        binding.allUsersBtn.setOnClickListener {
            Navigation.findNavController(binding.allUsersBtn)
                .navigate(R.id.action_home_screen_to_allUsers)
        }
        binding.allTransfersBtn.setOnClickListener {
            Navigation.findNavController(binding.allTransfersBtn)
                .navigate(R.id.action_home_screen_to_transferBalance)
        }

        return binding.root
    }



}