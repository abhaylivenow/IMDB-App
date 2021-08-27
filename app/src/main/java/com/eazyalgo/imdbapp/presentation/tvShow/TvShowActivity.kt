package com.eazyalgo.imdbapp.presentation.tvShow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eazyalgo.imdbapp.R
import com.eazyalgo.imdbapp.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}