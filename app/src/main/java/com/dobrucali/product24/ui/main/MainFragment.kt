package com.dobrucali.product24.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dobrucali.product24.databinding.FragmentMainBinding
import com.dobrucali.product24.ui.base.BaseFragment
import com.dobrucali.product24.viewModels.MainViewModel
import org.koin.android.ext.android.inject

class MainFragment : BaseFragment<MainViewModel>() {

    override val viewModel: MainViewModel by inject()
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

}