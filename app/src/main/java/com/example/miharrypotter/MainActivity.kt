package com.example.miharrypotter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miharrypotter.HarryPotterDetailActivity.Companion.EXTRA_ID
import com.example.miharrypotter.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: HarryAdapter
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        searchByName()
    }

    private fun initRecyclerView() {
        adapter = HarryAdapter{navegateDetail(it)}
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

    }
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://hp-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

    private fun searchByName() {
        CoroutineScope(Dispatchers.IO).launch {
            val myRespone = getRetrofit().create(ApiService::class.java).getcharacters()
            if (myRespone.isSuccessful) {
                val response: List<CharactersResponse> = myRespone.body().orEmpty()
                if (response != null) {
                    runOnUiThread {
                        adapter.updateList(response)
                    }
                }
            } else {
            }
        }
    }
    private fun navegateDetail(id:String){
        val intent=Intent(this,HarryPotterDetailActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)

    }




}