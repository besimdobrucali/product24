package com.dobrucali.product24.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.dobrucali.product24.R
import com.dobrucali.product24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val homeAsApList =
            setOf(R.id.product_detail_fragment)

        findNavController(R.id.nav_host_fragment)
            .addOnDestinationChangedListener { _, destination, _ ->

                supportActionBar?.setDisplayHomeAsUpEnabled(
                    homeAsApList.contains(destination.id)
                )

                if (destination.label.isNullOrBlank().not()) {
                    supportActionBar?.title = destination.label
                } else {
                    supportActionBar?.title = ""
                }
            }

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp() ?: false
    }

    fun handleLoading(isStatusNotLoading: Boolean) {
        binding.loading.loadingProgressLayout.isVisible = isStatusNotLoading
    }
}