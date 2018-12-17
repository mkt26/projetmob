package com.github.mkt26.pokemonlist.presentation.pokemonlist

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.github.mkt26.pokemonlist.data.repository.PokemonRepository
import com.github.mkt26.pokemonlist.di.PokemonApplication
import com.github.mkt26.pokemonlist.domain.Pokemon
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
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

        val disposable = pokemonRepository.getPokemonList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list -> liveDataListPokemon.value = list
            }, { t: Throwable? ->
                //TODO Show Error on Screen
                t!!.printStackTrace()
            })

        compositeDisposable.add(disposable)

    }

    private fun initializeDagger() = PokemonApplication.appComponent.inject(this)
}
