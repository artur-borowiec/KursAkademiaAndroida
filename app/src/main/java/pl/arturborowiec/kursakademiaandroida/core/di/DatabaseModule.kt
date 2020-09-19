package pl.arturborowiec.kursakademiaandroida.core.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.arturborowiec.kursakademiaandroida.core.database.AppDatabase

private const val DATABASE_NAME = "db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    single { get<AppDatabase>().episodeDao() }
    single { get<AppDatabase>().characterDao() }
}
