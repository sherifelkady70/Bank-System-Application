package com.route.banksystemapplication.ui.transferbalance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.banksystemapplication.R
import com.route.banksystemapplication.databinding.FragmentTransferBalanceBinding


class TransferBalance : Fragment() {
    lateinit var binding:FragmentTransferBalanceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         inflater.inflate(R.layout.fragment_transfer_balance, container, false)
        binding= FragmentTransferBalanceBinding.inflate(inflater)




        return binding.root
    }


}