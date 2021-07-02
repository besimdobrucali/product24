package com.dobrucali.product24.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dobrucali.product24.databinding.FragmentProductDetailBinding
import com.dobrucali.product24.ui.base.BaseFragment
import com.dobrucali.product24.viewModels.ProductDetailViewModel
import org.koin.android.ext.android.inject

class ProductDetailFragment : BaseFragment<ProductDetailViewModel>() {

    override val viewModel: ProductDetailViewModel by inject()
    lateinit var binding: FragmentProductDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentProductDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        arguments?.let {
            viewModel.bindArguments(it)
        }

        hideKeyboard()

        return binding.root
    }

}