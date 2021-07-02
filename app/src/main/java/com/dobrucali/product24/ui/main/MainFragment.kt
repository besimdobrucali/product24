package com.dobrucali.product24.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.dobrucali.product24.adapters.ProductAdapter
import com.dobrucali.product24.databinding.FragmentMainBinding
import com.dobrucali.product24.ui.base.BaseFragment
import com.dobrucali.product24.utils.OnClickListener
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

        binding.productRecyclerView.adapter = ProductAdapter(OnClickListener {

        })

        return binding.root
    }

}