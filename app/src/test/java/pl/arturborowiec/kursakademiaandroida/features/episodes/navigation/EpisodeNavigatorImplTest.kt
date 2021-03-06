package pl.arturborowiec.kursakademiaandroida.features.episodes.navigation

import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.navigation.FragmentNavigator
import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import pl.arturborowiec.kursakademiaandroida.mock.mock

internal class EpisodeNavigatorImplTest {

    @Test
    fun `WHEN openEpisodeDetailsScreen is called THEN invoke navigateTo method of FragmentNavigator with appropriate action and episode model as arguments`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)
        val episode = EpisodeDisplayable.mock()
        val slot = slot<Pair<String, EpisodeDisplayable>>()

        // when
        episodeNavigator.openEpisodeDetailScreen(episode)

        // then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_episodes_screen_to_episode_details_screen, capture(slot)
            )
        }
        slot.captured.second shouldBe episode
    }

    @Test
    fun `WHEN goBack is called THEN invoke goBack method of FragmentNavigator`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)

        // when
        episodeNavigator.goBack()

        // then
        verify { fragmentNavigator.goBack() }
    }
}
