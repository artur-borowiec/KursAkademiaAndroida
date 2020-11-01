package pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation

import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.BR
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment
import pl.arturborowiec.kursakademiaandroida.databinding.FragmentLocationBinding

class LocationFragment : BaseFragment<LocationViewModel, FragmentLocationBinding>(
    BR.viewModel,
    R.layout.fragment_location
) {

    override val viewModel: LocationViewModel by viewModel()

    private val gridLayoutManager: GridLayoutManager by inject()
    private val adapter: LocationAdapter by inject()

    override fun onDestroyView() {
        with(rvLocations) {
            layoutManager = null
            adapter = null
        }
        super.onDestroyView()
    }

    override fun initViews(binding: FragmentLocationBinding) {
        super.initViews(binding)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter.onLocationClickListener = { viewModel.onLocationClick(it) }
        binding?.let {
            rvLocations.layoutManager = gridLayoutManager
            rvLocations.adapter = adapter
        }
    }
}
