package com.example.android3lesson1dz.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3lesson1dz.data.model.GeneralModel

class MainFragmentViewModel : ViewModel() {

    private var list: MutableLiveData<ArrayList<GeneralModel>> = MutableLiveData()

    fun getListOfCatHTP(): MutableLiveData<ArrayList<GeneralModel>> {

        val generalModelArrayList: ArrayList<GeneralModel> = ArrayList()

        generalModelArrayList.add(GeneralModel("https://http.cat/100", "Continue"))
        generalModelArrayList.add(GeneralModel("https://http.cat/101", "Switching Protocols"))
        generalModelArrayList.add(GeneralModel("https://http.cat/102", "Processing"))
        generalModelArrayList.add(GeneralModel("https://http.cat/103", "Early Hints"))
        generalModelArrayList.add(GeneralModel("https://http.cat/200", "OK"))
        generalModelArrayList.add(GeneralModel("https://http.cat/201", "Created"))
        generalModelArrayList.add(GeneralModel("https://http.cat/202", "Accepted"))
        generalModelArrayList.add(GeneralModel("https://http.cat/203", "Non-Authoritative Information"))
        generalModelArrayList.add(GeneralModel("https://http.cat/204", "No Content"))
        generalModelArrayList.add(GeneralModel("https://http.cat/206", "Partial Content"))
        generalModelArrayList.add(GeneralModel("https://http.cat/207", "Multi-Status"))
        generalModelArrayList.add(GeneralModel("https://http.cat/300", "Multiple Choices"))
        generalModelArrayList.add(GeneralModel("https://http.cat/301", "Moved Permanently"))
        generalModelArrayList.add(GeneralModel("https://http.cat/302", "Found"))
        generalModelArrayList.add(GeneralModel("https://http.cat/303", "See Other"))
        generalModelArrayList.add(GeneralModel("https://http.cat/304", "Not Modified"))
        generalModelArrayList.add(GeneralModel("https://http.cat/305", "Use Proxy"))
        generalModelArrayList.add(GeneralModel("https://http.cat/307", "Temporary Redirect"))
        generalModelArrayList.add(GeneralModel("https://http.cat/308", "Permanent Redirect"))
        generalModelArrayList.add(GeneralModel("https://http.cat/400", "Bad Request"))
        generalModelArrayList.add(GeneralModel("https://http.cat/401", "Unauthorized"))
        generalModelArrayList.add(GeneralModel("https://http.cat/402", "Payment Required"))
        generalModelArrayList.add(GeneralModel("https://http.cat/403", "Forbidden"))
        generalModelArrayList.add(GeneralModel("https://http.cat/404", "Not Found"))
        generalModelArrayList.add(GeneralModel("https://http.cat/405", "Method Not Allowed"))
        generalModelArrayList.add(GeneralModel("https://http.cat/406", "Not Acceptable"))
        generalModelArrayList.add(GeneralModel("https://http.cat/407", "Proxy Authentication Required"))
        generalModelArrayList.add(GeneralModel("https://http.cat/408", "Request Timeout"))
        generalModelArrayList.add(GeneralModel("https://http.cat/409", "Conflict"))
        list.value = generalModelArrayList
        return list
    }
}