package pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_location.view.*
import pl.arturborowiec.kursakademiaandroida.core.adapter.BindableAdapter
import pl.arturborowiec.kursakademiaandroida.databinding.ItemLocationBinding
import pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationAdapter : BindableAdapter<LocationDisplayable>,
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private val locations by lazy { mutableListOf<LocationDisplayable>() }
    lateinit var onLocationClickListener: (LocationDisplayable) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLocationBinding.inflate(inflater, parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location, onLocationClickListener)
    }

    override fun setItems(items: List<LocationDisplayable>) {
        if (items.isNotEmpty()) {
            this.locations.clear()
        }

        this.locations.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = locations.size

    class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            location: LocationDisplayable,
            onLocationClicked: (LocationDisplayable) -> Unit
        ) {
            with(binding) {
                item = location
                root.setOnClickListener { onLocationClicked.invoke(location) }
                executePendingBindings()
            }
        }
    }
}
