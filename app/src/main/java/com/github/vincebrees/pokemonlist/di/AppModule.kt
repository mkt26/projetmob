package com.github.vincebrees.pokemonlist.di

import android.content.Context
import com.github.vincebrees.pokemonlist.data.repository.PokemonRepository
import com.github.vincebrees.pokemonlist.data.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vincent ETIENNE on 19/11/2018.
 */

@Module
class AppModule(private val application: PokemonApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides @Singleton fun providePokemonRepository(instance: PokemonRepositoryImpl): PokemonRepository = instance

}