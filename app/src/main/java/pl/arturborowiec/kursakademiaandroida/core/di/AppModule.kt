package pl.arturborowiec.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorMapper
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorMapperImpl
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorWrapper
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorWrapperImpl
import pl.arturborowiec.kursakademiaandroida.core.network.NetworkStateProvider
import pl.arturborowiec.kursakademiaandroida.core.network.NetworkStateProviderImpl

private const val GRID_COLUMNS_NUMBER = 2

val appModule = module {

    factory { LinearLayoutManager(androidContext()) }
    factory { GridLayoutManager(androidContext(), GRID_COLUMNS_NUMBER) }
    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }
    factory {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
}
