package pl.arturborowiec.kursakademiaandroida.features.episodes.navigation

import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.navigation.FragmentNavigator
import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import pl.arturborowiec.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsFragment

class EpisodeNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {

    override fun openEpisodeDetailScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
            EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}
