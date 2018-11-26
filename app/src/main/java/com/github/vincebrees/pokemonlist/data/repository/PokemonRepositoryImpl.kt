package com.github.vincebrees.pokemonlist.data.repository

import com.github.vincebrees.pokemonlist.data.remote.RestApiService
import com.github.vincebrees.pokemonlist.domain.Pokemon
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vincent ETIENNE on 19/11/2018.
 */

@Singleton
class PokemonRepositoryImpl @Inject constructor(
    private val restApiService: RestApiService
): PokemonRepository{

    override fun getPokemonList(): List<Pokemon> {
        //TODO Changer cette liste via WebService
        val list = arrayListOf<Pokemon>()
        list.add(Pokemon("Salameche", "url"))
        list.add(Pokemon("Carapuce", "url"))
        list.add(Pokemon("Bulbizarre", "url"))
        return list
    }
}