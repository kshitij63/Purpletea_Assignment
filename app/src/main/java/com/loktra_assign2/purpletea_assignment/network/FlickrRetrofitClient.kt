package com.loktra_assign2.purpletea_assignment.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by user on 5/16/2018.
 */
class FlickrRetrofitClient {

    companion object {
        var retrofit: Retrofit? = null

        fun getRetrofitClient(): Retrofit {

            if (retrofit == null) {
                var logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY

                var httpClient = OkHttpClient.Builder()
                httpClient.addInterceptor(logging)

//                val gson = GsonBuilder().setLenient().create()
                retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl("https://api.flickr.com/services/")
                        .client(httpClient.build())
                        .build()
            }

            return retrofit!!
        }
    }
}