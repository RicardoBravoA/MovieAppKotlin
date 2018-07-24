package com.example.s1089656.moviekotlinapp.model

import com.google.gson.annotations.SerializedName

data class MovieEntity(@SerializedName("page")
                       val page: Int = 0,
                       @SerializedName("total_pages")
                       val totalPages: Int = 0,
                       @SerializedName("results")
                       val results: List<ResultsItemEntity>?,
                       @SerializedName("total_results")
                       val totalResults: Int = 0)