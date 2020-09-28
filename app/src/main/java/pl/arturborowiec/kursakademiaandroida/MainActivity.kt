package pl.arturborowiec.kursakademiaandroida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import pl.arturborowiec.kursakademiaandroida.features.characters.presentation.CharacterFragment

class MainActivity : AppCompatActivity() {

    private val charactersFragment: CharacterFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, charactersFragment)
            .commit()
    }
}
