package com.eazyalgo.imdbapp.data.model.TvShow


import com.eazyalgo.imdbapp.data.model.TvShow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)