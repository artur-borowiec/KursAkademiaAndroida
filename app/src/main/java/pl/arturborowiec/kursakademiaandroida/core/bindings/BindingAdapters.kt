package pl.arturborowiec.kursakademiaandroida.core.bindings

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.Placeholder
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.arturborowiec.kursakademiaandroida.core.adapter.BindableAdapter
import pl.arturborowiec.kursakademiaandroida.core.base.UIState

object BindingAdapters {

    @BindingAdapter("app:showOnPendingState")
    @JvmStatic
    fun showOnPendingState(progressBar: ProgressBar, uiState: UIState) {
        progressBar.visibility = if (uiState == UIState.Pending) View.VISIBLE else View.GONE
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
        if (items.isNullOrEmpty()) return
        (recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)
    }

    @BindingAdapter(value = ["app:imageUrl", "app:placeholder"], requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, imageUrl: String, @DrawableRes placeholder: Int) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(placeholder)
            .into(imageView)
    }
}
