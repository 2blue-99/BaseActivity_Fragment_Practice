package com.example.baseactivity_fragment_practice.fragment.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseactivity_fragment_practice.R
import com.example.baseactivity_fragment_practice.databinding.ItemsBinding
import com.example.baseactivity_fragment_practice.dto.AppData
import com.example.domain.model.DomainData

/**
 * 2023-01-30
 * pureum
 */
class Adapter : RecyclerView.Adapter<Adapter.AdapterViewHolder>() {

    var dataList = arrayListOf<AppData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class AdapterViewHolder(private val binding : ItemsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(list: AppData){
            binding.name.text = list.name
            binding.status.text = list.status
            binding.species.text = list.species
            binding.image.text = list.image
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return when(viewType){
            0 -> {
                var binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.totalLayout.setBackgroundColor(Color.WHITE)
                AdapterViewHolder(binding)
            }
            1 -> {
                var binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.totalLayout.setBackgroundColor(Color.CYAN)
                return AdapterViewHolder(binding)
            }
            else -> {
                var binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.totalLayout.setBackgroundColor(Color.LTGRAY)
                return AdapterViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        Log.e("TAG", "onBindViewHolder", )
        holder.bind(dataList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].type
    }

    override fun getItemCount(): Int = dataList.size
}