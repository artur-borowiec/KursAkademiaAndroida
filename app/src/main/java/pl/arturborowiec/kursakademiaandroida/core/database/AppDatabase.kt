package pl.arturborowiec.kursakademiaandroida.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.arturborowiec.kursakademiaandroida.features.characters.data.local.CharacterDao
import pl.arturborowiec.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import pl.arturborowiec.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import pl.arturborowiec.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached

@Database(entities = [EpisodeCached::class, CharacterCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
    abstract fun characterDao(): CharacterDao
}
