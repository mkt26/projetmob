package com.github.mkt26.pokemonlist.data.repository

import com.github.mkt26.pokemonlist.data.remote.RestApiService
import com.github.mkt26.pokemonlist.domain.Pokemon
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vincent ETIENNE on 19/11/2018.
 */

@Singleton
class PokemonRepositoryImpl @Inject constructor(
    private val restApiService: RestApiService
): PokemonRepository {

    override fun getPokemonList(): Single<List<Pokemon>> {
        return restApiService.getListPokemon()
            .map{
                    response -> if(response.isSuccessful && response.body() != null){
                response.body()?.results
            }else{
                null
            }
            }
    }
}