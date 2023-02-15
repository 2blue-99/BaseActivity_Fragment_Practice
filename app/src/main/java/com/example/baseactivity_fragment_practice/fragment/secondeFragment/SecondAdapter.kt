package com.example.baseactivity_fragment_practice.fragment.secondeFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.baseactivity_fragment_practice.R
import com.example.baseactivity_fragment_practice.databinding.SecondItemsBinding
import com.example.baseactivity_fragment_practice.room.Entity
import com.example.domain.model.DomainData

/**
 * 2023-02-14
 * pureum
 */
class SecondAdapter(
    private val clickListener: (Entity) -> Unit
) : RecyclerView.Adapter<SecondAdapter.AdapterViewHolder>() {

    private lateinit var binding: SecondItemsBinding

    var dataList = listOf<Entity>()
        set(value) {
            field = value
            notifyDataSetChanged()
            Log.e("TAG", "$dataList", )
        }

    inner class AdapterViewHolder(private val binding : SecondItemsBinding ):RecyclerView.ViewHolder(binding.root){
        fun bind(list: Entity){
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
        binding = SecondItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
        binding.totalLayout.setOnClickListener{
            clickListener(item)
        }
    }

    override fun getItemCount(): Int = dataList.size

//    fun changeData(){ notifyDataSetChanged() }
}