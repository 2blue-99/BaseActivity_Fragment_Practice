package com.example.baseactivity_fragment_practice.fragment.mainFragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.baseactivity_fragment_practice.MainActivity
import com.example.baseactivity_fragment_practice.R
import com.example.baseactivity_fragment_practice.viewModel.MainViewModel
import com.example.baseactivity_fragment_practice.databinding.FragmentMainBinding
import com.example.baseactivity_fragment_practice.fragment.base.BaseFragment
import com.example.domain.model.DomainData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val activityViewModel : MainViewModel by activityViewModels()
    private val adapter = MainAdapter(clickListener = { getDialog(it) })


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        CoroutineScope(Dispatchers.IO).launch {
            activityViewModel.myGetData("1").collectLatest {
                adapter.submitData(it)
            }
        }

        binding.button.setOnClickListener{
            downKeyBoard()
            CoroutineScope(Dispatchers.IO).launch {
                activityViewModel.myGetData(binding.textField.text.toString()).collectLatest {
                    adapter.submitData(it)
                }
            }
        }

        binding.root.setOnClickListener { downKeyBoard() }

        binding.textField.setOnEditorActionListener(getEditActionListener(binding.button))

        binding.swipeRefreshLayout.setOnRefreshListener {
            adapter.refresh()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    fun initRecyclerView(){
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter
        //findNavController().navigate(R.id.action_mainFragment_to_firtstFragment)네비게이션
    }

    fun downKeyBoard() {
        (activity as MainActivity).downKeyBoard()
    }

    fun getEditActionListener(view: View): TextView.OnEditorActionListener{
        return TextView.OnEditorActionListener{ textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                view.callOnClick()
            }
            false
        }
    }

    fun getDialog(list:DomainData){
        AlertDialog.Builder(requireContext())
            .setTitle("저장")
            .setMessage("${list.name}를 저장 하시겠습니까?")
            .setPositiveButton("확인") { dialog, id ->
                activityViewModel.insertData(list)
            }
            .setNegativeButton("취소"){ dialog, id -> }.show()
    }
}