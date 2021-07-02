package com.dobrucali.product24.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.dobrucali.product24.data.entity.FilterType
import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.data.entity.Status
import com.dobrucali.product24.task.FavouriteTask
import com.dobrucali.product24.task.ProductTask
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch

class MainViewModel(
    private val productTask: ProductTask,
    private val favouriteTask: FavouriteTask
) : BaseViewModel() {

    private val _menuItems = MutableLiveData<List<String>>()
    val menuItems: LiveData<List<String>>
        get() = _menuItems

    private val _currentTab = MutableLiveData<Int>()
    val currentTab: LiveData<Int>
        get() = _currentTab

    private val _productList = MutableLiveData<List<ProductsItem>>()
    val productList: LiveData<List<ProductsItem>>
        get() = _productList

    private val favouriteList: LiveData<List<ProductsItem>> = favouriteTask.getFavouriteProductList()

    init {
        _currentTab.value = DEFAULT_TAB
        getProducts()
    }

    val filteredProductList = Transformations.map(currentTab) { currentTab ->
        val productList = productList.value
        when(currentTab){
            FilterType.ALL.ordinal -> productList
            FilterType.AVAILABLE.ordinal -> productList?.filter { it.available == true }
            FilterType.FAVOURITE.ordinal -> productList?.filter { favouriteList.value?.contains(it.id) == true }
            else -> listOf()
        }
    }

    fun addOnTabSelectedListener(): TabLayout.OnTabSelectedListener {
        return object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = menuItems.value?.indexOfFirst { it == tab.tag } ?: 0
                _currentTab.value = position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        }
    }

    fun getProducts() {
        viewModelScope.launch {
            try {
                _status.value = Status.LOADING
                val result = productTask.getProducts()
                _status.value = result.status
                when (result.status) {
                    Status.SUCCESS -> {
                        result.data?.let { response ->
                            _menuItems.value = response.filters?.filterNotNull()
                            _productList.value = response.products?.filterNotNull()
                            refreshCurrentTab()
                        }
                    }
                    Status.ERROR -> {
                        _errorMessage.value = result.error?.message
                    }
                    else -> {}
                }
            } catch (error: Exception) {
                _status.value = Status.ERROR
                _errorMessage.value = error.message
            }
        }
    }

    // refresh the recycler view list
    private fun refreshCurrentTab(){
        _currentTab.value = currentTab.value
    }

    companion object{
        val DEFAULT_TAB = 0
    }

}
