package com.example.baseactivity_fragment_practice.fragment.mainFragment

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.baseactivity_fragment_practice.databinding.ItemsBinding
import com.example.domain.model.DomainData
import java.math.MathContext

/**
 * 2023-01-30
 * pureum
 */
class MainAdapter(
    private val clickListener: (DomainData) -> Unit
) : RecyclerView.Adapter<MainAdapter.AdapterViewHolder>() {

    private lateinit var binding : ItemsBinding

    var dataList = listOf<DomainData>()
        set(value) {
            field = value
            notifyDataSetChanged()
            //Log.e("TAG", "$dataList", )
        }


    inner class AdapterViewHolder(private val binding : ItemsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(list: DomainData){
            binding.name.text = list.name
            binding.status.text = list.status
            binding.species.text = list.species
            Glide.with(itemView).load(list.image).circleCrop().into(binding.imageView)

            binding.totalLayout.setOnClickListener{
                clickListener(list)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return when(viewType){
            0 -> {
                var binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.totalLayout.setBackgroundColor(Color.rgb(249,212,255))
                AdapterViewHolder(binding)
            }
            1 -> {
                var binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.totalLayout.setBackgroundColor(Color.rgb(203,255,250))
                return AdapterViewHolder(binding)
            }
            else -> {
                var binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.totalLayout.setBackgroundColor(Color.rgb(255,186,181))
                return AdapterViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        //Log.e("TAG", "onBindViewHolder", )
        val item = dataList[position]
        holder.bind(item)
        binding.totalLayout.setOnClickListener{
            clickListener(item)
        }
    }

    override fun getItemCount(): Int = dataList.size
}