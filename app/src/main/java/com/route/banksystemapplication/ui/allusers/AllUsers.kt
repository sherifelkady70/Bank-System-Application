package com.route.banksystemapplication.ui.allusers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.route.banksystemapplication.R
import com.route.banksystemapplication.databinding.FragmentAllUsersBinding


class AllUsers : Fragment() {
    lateinit var binding : FragmentAllUsersBinding
    lateinit var viewModel:AllUsersViewModel
    lateinit var adapter : CustomAllUsersAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         inflater.inflate(R.layout.fragment_all_users, container, false)
        binding= FragmentAllUsersBinding.inflate(inflater)

        viewModel = ViewModelProvider(this
            ,AllUsersViewModelFactory(requireActivity().application)).get(AllUsersViewModel::class.java)

        rvPrapare()
        return binding.root
    }

    private fun rvPrapare(){
        adapter= CustomAllUsersAdapter()
        binding.userRv.layoutManager=LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)

        activity?.let {
            viewModel.readAllUsers.observe(viewLifecycleOwner,
                {
                    adapter.differ.submitList(it)
                    binding.userRv.adapter=adapter
                })
        }
    }
}