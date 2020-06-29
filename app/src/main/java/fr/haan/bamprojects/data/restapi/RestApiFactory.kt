package fr.haan.bamprojects.data.restapi

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val webservice by lazy {


    val interceptor = HttpLoggingInterceptor()
    interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build().create(BamGithubApi::class.java)
}

val bamGithubApiClient by lazy {
    BamGithubApiClient(webservice)
}