package com.ntpro.mobileandroiddevtestwork

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val dealLiveData = MutableLiveData<MutableList<Server.Deal>?>()

    init {
        dealLiveData.value = ArrayList()
    }

    fun addDealPacket(deal: Server.Deal) {
        dealLiveData.value?.add(deal)
        dealLiveData.value = dealLiveData.value
    }

}