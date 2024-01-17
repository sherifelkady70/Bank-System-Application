package com.route.banksystemapplication.ui.transferbalance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.route.banksystemapplication.R
import com.route.banksystemapplication.databinding.FragmentTransferBalanceBinding


class TransferBalance : Fragment() {
    lateinit var binding:FragmentTransferBalanceBinding
    lateinit var adapter:CustomAdapterTransfer
    lateinit var viewModel:TransferViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         inflater.inflate(R.layout.fragment_transfer_balance, container, false)
        binding= FragmentTransferBalanceBinding.inflate(inflater)

//        viewModel=ViewModelProvider(this,
//        TransferViewModelFactory(requireActivity().application)).get(TransferViewModel::class.java)
        viewModel=ViewModelProvider(this).get(TransferViewModel::class.java)

        rvPrepare()
        return binding.root
    }
    private fun rvPrepare(){
        adapter= CustomAdapterTransfer()
        binding.RVTransferRecord.layoutManager=LinearLayoutManager(requireActivity(),
        RecyclerView.VERTICAL,false)
        binding.RVTransferRecord.adapter=adapter
        activity?.let {
            viewModel.getData()?.observe(
                viewLifecycleOwner,{
                    adapter.differ.submitList(it)

            })
        }
    }

}