package com.example.baseactivity_fragment_practice.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseactivity_fragment_practice.MainViewModel
import com.example.baseactivity_fragment_practice.R
import com.example.baseactivity_fragment_practice.databinding.FragmentMainBinding
import com.example.baseactivity_fragment_practice.databinding.ItemsBinding
import com.example.baseactivity_fragment_practice.fragment.adapter.Adapter

class MainFragment : Fragment() {

    private val activityViewModel : MainViewModel by activityViewModels()
    private val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }
    private val adapter = Adapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activityViewModel.myGetData()
        activityViewModel.data.observe(viewLifecycleOwner){
            if(it != null) {
//                adapter.nameList = it.name
//                adapter.statusList = it.name
//                adapter.speciesList = it.name
//                adapter.imageList = it.name
            }
            else
                Log.e("TAG", "onCreateView: err", )
        }
        binding.button.setOnClickListener{ activityViewModel.myGetData(binding.textField.text.toString()) }

        initRecyclerView()

        return binding.root
    }

    fun initRecyclerView(){
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter
    }

}