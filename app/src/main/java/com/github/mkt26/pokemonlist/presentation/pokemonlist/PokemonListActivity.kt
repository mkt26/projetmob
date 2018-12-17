package com.github.mkt26.pokemonlist.presentation.pokemonlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.github.mkt26.pokemonlist.R
import com.github.mkt26.pokemonlist.domain.Pokemon
import kotlinx.android.synthetic.main.activity_pokemon_list.*

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
                list -> if(list != null) setupRecyclerView(list)
        })
    }

    private fun setupRecyclerView(list: List<Pokemon>) {
        val linearLayoutManager = LinearLayoutManager(this)
        recycler_list_pokemon.layoutManager = linearLayoutManager
        recycler_list_pokemon.adapter = PokemonAdapter(this, list)
        val dividerItemDecoration = DividerItemDecoration(recycler_list_pokemon.context, linearLayoutManager.orientation)
        recycler_list_pokemon.addItemDecoration(dividerItemDecoration)
    }
}