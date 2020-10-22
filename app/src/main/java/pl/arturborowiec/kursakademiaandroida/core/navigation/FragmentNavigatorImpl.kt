package pl.arturborowiec.kursakademiaandroida.core.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.provider.ActivityProvider

class FragmentNavigatorImpl(
    private val activityProvider: ActivityProvider,
    @IdRes private val navHostFragmentRes: Int,
    @IdRes private val homeDestinationRes: Int,
    private val defaultNavOptions: NavOptions
) : FragmentNavigator {

    private fun getSupportFragmentManager() =
        (activityProvider.foregroundActivity as? FragmentActivity)?.supportFragmentManager

    private fun getNavController() = getSupportFragmentManager()
        ?.findFragmentById(navHostFragmentRes)
        ?.findNavController()

    override fun navigateTo(
        destinationId: Int,
        bundle: Bundle?,
        fragmentTransition: FragmentTransition?
    ) {
        val navOptions = fragmentTransition?.let {
            navOptions {
                anim { enter = it.enterAnim }
                anim { exit = it.exitAnim }
                anim { popEnter = it.popEnterAnim }
                anim { popExit = it.popExitAnim }
            }
        } ?: defaultNavOptions

        getNavController()?.navigate(destinationId, bundle, navOptions)
    }

    override fun goBack(destinationId: Int?, inclusive: Boolean) {
        if (destinationId == null) getNavController()?.popBackStack()
        else getNavController()?.popBackStack(destinationId, inclusive)
    }

    override fun clearHistory() {
        goBack(homeDestinationRes)
    }
}
