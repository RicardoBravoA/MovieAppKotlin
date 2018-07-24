package com.example.s1089656.moviekotlinapp.data.repository

import com.example.s1089656.moviekotlinapp.model.MovieEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ricardo Bravo on 20/07/2018.
 */

interface ApiService {

    @GET("movie/popular'")
    fun popularMovie(@Query("api_key") apiKey: String, @Query("language") language: String,
                     @Query("page") page: String): Observable<MovieEntity>

    @GET("movie/top_rated'")
    fun topRatedMovie(@Query("api_key") apiKey: String, @Query("language") language: String,
                      @Query("page") page: String): Observable<MovieEntity>

    @GET("movie/upcoming'")
    fun upcomingMovie(@Query("api_key") apiKey: String, @Query("language") language: String,
                      @Query("page") page: String): Observable<MovieEntity>

}