package com.route.banksystemapplication.ui.allusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.route.banksystemapplication.databinding.FragmentHomeScreenBinding
import com.route.banksystemapplication.databinding.ItemRvUsersBinding
import com.route.banksystemapplication.roomdatabase.entities.UsersTable

class CustomAllUsersAdapter : RecyclerView.Adapter<CustomAllUsersAdapter.ViewHolder>(){


    private val differCallback = object : DiffUtil.ItemCallback<UsersTable>(){
        override fun areItemsTheSame(oldItem: UsersTable, newItem: UsersTable): Boolean {
          return  oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: UsersTable, newItem: UsersTable): Boolean {
            return oldItem==newItem
        }

    }
    val differ =AsyncListDiffer(this,differCallback)
    class ViewHolder(var binding: ItemRvUsersBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v  = ItemRvUsersBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data : UsersTable = differ.currentList[position]
        holder.binding.tvNameItem.text=data.name
        holder.binding.tvEmailItem.text=data.email
        holder.binding.tvBalanceItem.text=data.currentBalance.toString()
    }
}