package com.github.vincebrees.pokemonlist.presentation.pokemonlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.vincebrees.pokemonlist.R
import com.github.vincebrees.pokemonlist.domain.Pokemon

class PokemonListActivity : AppCompatActivity() {

    private lateinit var viewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
        initViewModel()
        initObserver()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        viewModel.let { lifecycle.addObserver(it) }
    }

    private fun initObserver() {
        viewModel.liveDataListPokemon.observe(this, Observer {
            list -> setupRecyclerView(list)
        })
    }

    private fun setupRecyclerView(list: List<Pokemon>?) {
        //TODO Implement Recycler view
        Log.d("Test", "Data list")
    }
}
