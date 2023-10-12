package com.example.miharrypotter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miharrypotter.databinding.ActivityHarryPotterDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HarryPotterDetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID="extra_id"
    }
    private lateinit var binding:ActivityHarryPotterDetailBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harry_potter_detail)
        binding= ActivityHarryPotterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: String =intent.getStringExtra(EXTRA_ID).orEmpty()
        getHarryDetailInformation(id)
    }
    private fun getHarryDetailInformation(id:String){
        CoroutineScope(Dispatchers.IO).launch {
            val HarryDetail=
                getRetrofit().create(ApiService::class.java).getCharacterDetail(id)
            if(HarryDetail.body()!=null){
                runOnUiThread{createdUi(HarryDetail.body()!!)}
            }
        }
    }

    private fun createdUi(body: List<CharactersResponse>) {
        val character: CharactersResponse = body[0]
        binding.tvHarryDetail.text=character.name
        binding.tvBotom.text=character.ancestry


    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://hp-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }
}