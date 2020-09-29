package com.example.rvkotlinretrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://reqres.in"
interface ExampleServicesInterface{

    @GET("/api/users?page=2")
    fun getDetails(): Call<ReqresUser>
}

object ExampleServices{
    val ExampleInstance: ExampleServicesInterface

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        ExampleInstance = retrofit.create(ExampleServicesInterface::class.java)
    }

}