package pl.arturborowiec.kursakademiaandroida.features.locations.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_episode.*
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    private val gridLayoutManager: GridLayoutManager by inject()
    private val adapter: LocationAdapter by inject()

    override fun initViews() {
        super.initViews()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rvLocations.layoutManager = gridLayoutManager
        rvLocations.adapter = adapter
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            adapter.setLocations(it)
        }
    }

    override fun onDestroyView() {
        with(rvLocations) {
            layoutManager = null
            adapter = null
        }
        super.onDestroyView()
    }
}
