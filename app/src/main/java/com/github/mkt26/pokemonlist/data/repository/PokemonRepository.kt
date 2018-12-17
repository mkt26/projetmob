package com.github.mkt26.pokemonlist.data.repository

import com.github.mkt26.pokemonlist.domain.Pokemon
import io.reactivex.Single

/**
 * Created by Vincent ETIENNE on 19/11/2018.
 */

interface PokemonRepository{

    fun getPokemonList() : Single<List<Pokemon>>
}