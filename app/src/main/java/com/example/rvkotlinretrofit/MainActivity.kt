package com.example.rvkotlinretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var dataList: MutableList<ExampleItem> = mutableListOf()
    lateinit var adapter: ExampleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        dataList.add(ExampleItem(R.drawable.ic_launcher_foreground,"admin","test"))
//
//        adapter = ExampleAdapter(dataList)
//
//        recycler_view.adapter = adapter
//        recycler_view.layoutManager = LinearLayoutManager(this)
//        recycler_view.setHasFixedSize(true)

        getData()
    }

    private fun getData() {
        val news: Call<ReqresUser> = ExampleServices.ExampleInstance.getDetails()
        news.enqueue(object: Callback<ReqresUser>{
            override fun onFailure(call: Call<ReqresUser>, t: Throwable) {
                Log.d("SAVAN","Error",t)
            }

            override fun onResponse(call: Call<ReqresUser>, response: Response<ReqresUser>) {
                val news: ReqresUser? = response.body()
                if(news != null)
                {
                    Log.d("SAVAN",news.data[0].avatar)
                    adapter = ExampleAdapter(news.data)

                    recycler_view.adapter = adapter
                    recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

        })

    }
}