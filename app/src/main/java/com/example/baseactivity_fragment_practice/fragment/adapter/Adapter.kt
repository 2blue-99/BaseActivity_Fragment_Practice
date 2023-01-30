package com.example.baseactivity_fragment_practice.fragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseactivity_fragment_practice.databinding.ItemsBinding
import com.example.domain.model.DomainData

/**
 * 2023-01-30
 * pureum
 */
class Adapter : RecyclerView.Adapter<Adapter.AdapterViewHolder>() {
    var nameList = listOf<String?>()
    var statusList = listOf<String?>()
    var speciesList = listOf<String?>()
    var imageList = listOf<String?>()
        set(value) {
            field = value
            notifyDataSetChanged()
            Log.e("TAG", ": $nameList", )
            Log.e("TAG", ": $statusList", )
            Log.e("TAG", ": $speciesList", )
            Log.e("TAG", ": $imageList", )
        }

    inner class AdapterViewHolder(private val binding : ItemsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(list:String?){
            binding.name.text = list
            binding.status.text = list
            binding.species.text = list
            binding.image.text = "hello"//list.image[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.e("TAG", "onCreateViewHolder: $viewType", )
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(nameList[position])
    }

    override fun getItemCount(): Int = nameList.size
}