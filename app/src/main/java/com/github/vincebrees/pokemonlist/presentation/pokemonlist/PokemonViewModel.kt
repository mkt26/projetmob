package com.github.vincebrees.pokemonlist.presentation.pokemonlist

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.github.vincebrees.pokemonlist.data.repository.PokemonRepository
import com.github.vincebrees.pokemonlist.di.PokemonApplication
import com.github.vincebrees.pokemonlist.domain.Pokemon
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Vincent ETIENNE on 19/11/2018.
 */

class PokemonViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var pokemonRepository: PokemonRepository

    private val compositeDisposable = CompositeDisposable()

    var liveDataListPokemon: MutableLiveData<List<Pokemon>> = MutableLiveData()

    init {
        initializeDagger()

        liveDataListPokemon.value = pokemonRepository.getPokemonList()
    }

    private fun initializeDagger() = PokemonApplication.appComponent.inject(this)
}