package ru.otus.a220903newtestmodel.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory private constructor() {

    private var retrofit: Retrofit
    private val BASE_URL = "https://api.vk.com/method/"

    init {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    companion object{
        var apiFactory: ApiFactory? = ApiFactory()

        fun getInstance(): ApiFactory{
            if (apiFactory == null){
                apiFactory = ApiFactory()
            }
            return apiFactory as ApiFactory
        }
    }

    fun getApiService():ApiService{
        return retrofit.create(ApiService::class.java)
    }
}