package pl.arturborowiec.kursakademiaandroida.core.di

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val GRID_COLUMNS_NUMBER = 2

val appModule = module {

    single {
        LinearLayoutManager(androidContext())
    }

    single {
        GridLayoutManager(androidContext(), GRID_COLUMNS_NUMBER)
    }

    single {
        DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL)
    }
}