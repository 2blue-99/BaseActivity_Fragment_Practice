package com.example.baseactivity_fragment_practice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baseactivity_fragment_practice.R
import com.example.baseactivity_fragment_practice.databinding.FragmentSecondeBinding
import com.example.baseactivity_fragment_practice.fragment.base.BaseFragment

class SecondeFragment : BaseFragment<FragmentSecondeBinding>(FragmentSecondeBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}