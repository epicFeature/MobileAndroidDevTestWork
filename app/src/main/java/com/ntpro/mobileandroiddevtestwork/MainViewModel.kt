package com.ntpro.mobileandroiddevtestwork

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


//    fun addDealPacket(deal: Server.Deal) {
//        dealLiveData.value?.add(deal)
//        dealLiveData.value = dealLiveData.value
//    }

    fun subScribe(callback: (List<Server.Deal>) -> Unit) {
        Server().subscribeToDeals { callback(it) }
    }

    //flow не в main thread
    //который принимает данные и каждый раз, когда обновляется начинает что-то делать
    //мерджит их туда

    //вывод функции вне мейн треда
}