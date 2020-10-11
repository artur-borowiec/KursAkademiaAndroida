package pl.arturborowiec.kursakademiaandroida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import pl.arturborowiec.kursakademiaandroida.features.characters.presentation.CharacterFragment
import pl.arturborowiec.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import pl.arturborowiec.kursakademiaandroida.features.locations.presentation.LocationFragment

class MainActivity : AppCompatActivity() {

    private val charactersFragment: CharacterFragment by inject()
    private val locationFragment: LocationFragment by inject()
    private val episodeFragment: EpisodeFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, episodeFragment)
            .commit()
    }
}
