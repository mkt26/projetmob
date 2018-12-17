package com.github.mkt26.pokemonlist.data.remote

import com.github.mkt26.pokemonlist.data.pojo.RestPokemonData
import com.github.mkt26.pokemonlist.domain.Pokemon
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
/**
 * Created by Vincent ETIENNE on 19/11/2018.
 */

interface RestApiService{

    @GET("/api/v2/pokemon")
    fun getListPokemon(): Single<Response<RestPokemonData>>
}