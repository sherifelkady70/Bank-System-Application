package com.route.banksystemapplication.ui.transferbalance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.route.banksystemapplication.databinding.ItemRvTransfersBinding
import com.route.banksystemapplication.roomdatabase.entities.TransferTable

class CustomAdapterTransfer : RecyclerView.Adapter<CustomAdapterTransfer.ViewHolder>(){


    val differCallback = object : DiffUtil.ItemCallback<TransferTable>(){
        override fun areItemsTheSame(oldItem: TransferTable, newItem: TransferTable): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: TransferTable, newItem: TransferTable): Boolean {
            return oldItem==newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)

    class ViewHolder(var binding:ItemRvTransfersBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemRvTransfersBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data : TransferTable = differ.currentList[position]
        holder.binding.tvSender.text=data.sender
        holder.binding.tvReceiver.text=data.receiver
        holder.binding.tvAmountTransfer.text=data.amount.toString()
    }
}