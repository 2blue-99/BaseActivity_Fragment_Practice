package com.example.baseactivity_fragment_practice.fragment.mainFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseactivity_fragment_practice.viewModel.MainViewModel
import com.example.baseactivity_fragment_practice.databinding.FragmentMainBinding
import com.example.baseactivity_fragment_practice.fragment.base.BaseFragment


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val activityViewModel : MainViewModel by activityViewModels()
    private val adapter = Adapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityViewModel.myGetData()
        activityViewModel.data.observe(viewLifecycleOwner){ adapter.dataList = it }
        binding.button.setOnClickListener{ activityViewModel.myGetData(binding.textField.text.toString()) }
        initRecyclerView()
    }

    fun initRecyclerView(){
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter
    }

}