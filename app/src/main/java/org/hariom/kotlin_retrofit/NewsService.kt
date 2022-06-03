package org.hariom.kotlin_retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/top-headlines?country=in&apiKey=7823c7e84e5c4ae2b07d868e3fb9ce73
const val BASE_URL = "https://newsapi.org"
const val API_KEY = "7823c7e84e5c4ae2b07d868e3fb9ce73"
interface NewsInterface {

    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country : String, @Query("page") page : Int) : Call<News>
}


object NewsService{
    var newsInstance : NewsInterface
    init {
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}

