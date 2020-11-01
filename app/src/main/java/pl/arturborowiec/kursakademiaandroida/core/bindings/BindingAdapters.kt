package pl.arturborowiec.kursakademiaandroida.core.bindings

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.arturborowiec.kursakademiaandroida.core.adapter.BindableAdapter
import pl.arturborowiec.kursakademiaandroida.core.base.UIState

object BindingAdapters {

    @BindingAdapter("app:showOnPendingState")
    @JvmStatic
    fun showOnPendingState(progressBar: ProgressBar, uiState: UIState) {
        progressBar.visibility = if(uiState == UIState.Pending) View.VISIBLE else View.GONE
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
        if (items.isNullOrEmpty()) return
        (recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)
    }
}
