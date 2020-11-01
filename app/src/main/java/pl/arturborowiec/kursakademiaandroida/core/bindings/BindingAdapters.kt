package pl.arturborowiec.kursakademiaandroida.core.bindings

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import pl.arturborowiec.kursakademiaandroida.core.base.UIState

object BindingAdapters {

    @BindingAdapter("app:showOnPendingState")
    @JvmStatic
    fun showOnPendingState(progressBar: ProgressBar, uiState: UIState) {
        progressBar.visibility = if(uiState == UIState.Pending) View.VISIBLE else View.GONE
    }
}