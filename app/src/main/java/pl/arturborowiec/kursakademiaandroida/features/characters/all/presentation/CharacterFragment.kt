package pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_character.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.BR
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment
import pl.arturborowiec.kursakademiaandroida.databinding.FragmentCharacterBinding

class CharacterFragment : BaseFragment<CharacterViewModel, FragmentCharacterBinding>(
    BR.viewModel,
    R.layout.fragment_character
) {

    override val viewModel: CharacterViewModel by viewModel()

    private val gridLayoutManager: GridLayoutManager by inject()
    private val adapter: CharacterAdapter by inject()

    override fun onDestroyView() {
        with(rvCharacters) {
            layoutManager = null
            adapter = null
        }
        super.onDestroyView()
    }

    override fun initViews(binding: FragmentCharacterBinding) {
        super.initViews(binding)
        setupRecyclerView()
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
        binding?.pbCharacters?.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        binding?.pbCharacters?.visibility = View.VISIBLE
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            adapter.setCharacters(it)
        }
    }

    private fun setupRecyclerView() {
        adapter.onCharacterClickListener = { viewModel.onCharacterClick(it) }
        binding?.let {
            rvCharacters.layoutManager = gridLayoutManager
            rvCharacters.adapter = adapter
        }
    }
}
