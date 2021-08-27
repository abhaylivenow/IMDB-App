package com.eazyalgo.imdbapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eazyalgo.imdbapp.R
import com.eazyalgo.imdbapp.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}