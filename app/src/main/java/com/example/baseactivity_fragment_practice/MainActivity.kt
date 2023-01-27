package com.example.baseactivity_fragment_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val data = Retrofit.Builder()
//            .baseUrl("https://rickandmortyapi.com/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(RetrofitInter::class.java).getData()?.enqueue(object : Callback<API_Data> {
//                override fun onResponse(call: Call<API_Data>, response: Response<API_Data>) {
//                    Log.e("TAG", "onResponse: ${response.body().toString()}", )
//                }
//
//                override fun onFailure(call: Call<API_Data>, t: Throwable) {
//                    Log.e("TAG", "err : $t", )
//                }
//            })


        viewModel.data.observe(this) {
            Log.e("TAG", "onCreate: $it",)
        }

        viewModel.myGetData()
    }
}