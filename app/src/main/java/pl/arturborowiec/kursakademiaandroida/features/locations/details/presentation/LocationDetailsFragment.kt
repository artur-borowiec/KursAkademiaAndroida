package pl.arturborowiec.kursakademiaandroida.features.locations.details.presentation

import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.BR
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment
import pl.arturborowiec.kursakademiaandroida.databinding.FragmentLocationDetailsBinding

class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel, FragmentLocationDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_location_details
    ) {

    override val viewModel: LocationDetailsViewModel by viewModel()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }
}
