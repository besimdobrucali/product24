package com.dobrucali.product24.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.dobrucali.product24.R
import com.dobrucali.product24.adapters.ProductAdapter
import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.databinding.FragmentMainBinding
import com.dobrucali.product24.ui.base.BaseFragment
import com.dobrucali.product24.utils.Constants
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

        viewModel.menuItems.observe(viewLifecycleOwner, { menuItems ->
            menuItems?.let {
                binding.menuTabLayout.removeAllTabs()
                menuItems.forEach { header ->
                    binding.menuTabLayout.apply {
                        addTab(newTab().setText(header).setTag(header))
                    }
                }
            }
        })

        viewModel.currentTab.observe(viewLifecycleOwner, { tab ->
            tab?.let {
                var visibleTabCount = 0
                for (index in 0.until(binding.menuTabLayout.tabCount)) {
                    if ((binding.menuTabLayout.getTabAt(index)?.view as LinearLayout).visibility == View.VISIBLE) {
                        visibleTabCount++
                    }
                }
                if (binding.menuTabLayout.tabCount > 0 && binding.menuTabLayout.selectedTabPosition != tab && visibleTabCount > tab) {
                    binding.menuTabLayout.getTabAt(tab)?.select()
                }
            }
        })

        binding.productRecyclerView.adapter = ProductAdapter {
            navigateProductDetail(it)
        }

        binding.swipeRefreshLayout.setColorSchemeResources(
            R.color.purple_200,
            R.color.purple_500,
            R.color.purple_200
        )
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            viewModel.getProducts()
        }

        viewModel.favouriteList.observe(viewLifecycleOwner, { favouriteList ->
            favouriteList?.let {

            }
        })

        return binding.root
    }

    private fun navigateProductDetail(product: ProductsItem) {
        val arguments = Bundle()
        arguments.putParcelable(Constants.PRODUCT_KEY, product)
        findNavController().navigate(
            R.id.action_main_fragment_to_detail_fragment,
            arguments,
            null,
            null
        )
    }
}