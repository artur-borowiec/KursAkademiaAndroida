package pl.arturborowiec.kursakademiaandroida.features.locations.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_location.view.*
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.features.locations.presentation.model.LocationDisplayable

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private val locations by lazy { mutableListOf<LocationDisplayable>() }

    fun setLocations(locations: List<LocationDisplayable>) {
        if (locations.isNotEmpty()) {
            this.locations.clear()
        }

        this.locations.addAll(locations)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_location, parent, false)

        return LocationViewHolder(itemView)
    }

    override fun getItemCount(): Int = locations.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)
    }

    class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(location: LocationDisplayable) {
            with(itemView) {
                textView.text = location.name
            }
        }
    }
}