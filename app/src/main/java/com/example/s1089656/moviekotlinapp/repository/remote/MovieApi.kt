package com.example.s1089656.moviekotlinapp.repository.remote

import android.arch.lifecycle.LiveData
import com.example.s1089656.moviekotlinapp.BuildConfig
import com.example.s1089656.moviekotlinapp.model.MovieEntity
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ricardo Bravo on 23/07/18.
 */

interface ApiService {

    @GET(BuildConfig.MOVIE_POPULAR)
    fun popularMovie(@Query("api_key") apiKey: String, @Query("language") language: String,
                     @Query("page") page: String): LiveData<MovieEntity>

    @GET(BuildConfig.TOP_RATED)
    fun topRatedMovie(@Query("api_key") apiKey: String, @Query("language") language: String,
                      @Query("page") page: String): LiveData<MovieEntity>

    @GET(BuildConfig.UPCOMING)
    fun upcomingMovie(@Query("api_key") apiKey: String, @Query("language") language: String,
                      @Query("page") page: String): LiveData<MovieEntity>

}