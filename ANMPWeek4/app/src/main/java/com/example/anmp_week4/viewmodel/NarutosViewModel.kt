package com.example.anmp_week4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.anmp_week4.model.Naruto
import com.example.anmp_week4.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NarutosViewModel(application: Application):AndroidViewModel(application) {
    val narutoLD = MutableLiveData<ArrayList<Naruto>>()
    val tag = "volleyTagNaruto"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication() )
        val url = "http://10.0.2.2/anmp/naruto.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Naruto>>() { }.type
                val result = Gson().fromJson<List<Naruto>>(it, sType)
                narutoLD.value = result as ArrayList<Naruto>?
                Log.d("narutovoley", result.toString())
            },
            {
                Log.d("narutovoley", it.toString())

            })
        stringRequest.tag = tag
        queue?.add(stringRequest)
    }
}