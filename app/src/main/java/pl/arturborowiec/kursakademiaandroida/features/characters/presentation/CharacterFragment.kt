package pl.arturborowiec.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_character.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

    private val adapter: CharacterAdapter by inject()

    override fun initViews() {
        super.initViews()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rvCharacters.layoutManager = get<GridLayoutManager>()
        rvCharacters.adapter = adapter
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            adapter.setCharacters(it)
        }
    }
}
