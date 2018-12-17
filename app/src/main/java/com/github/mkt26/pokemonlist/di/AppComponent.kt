package com.github.mkt26.pokemonlist.di

import com.github.mkt26.pokemonlist.presentation.pokemonlist.PokemonViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, RemoteModule::class])
@Singleton
interface AppComponent {

  fun inject(viewModel: PokemonViewModel)

}