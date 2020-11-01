package pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.arturborowiec.kursakademiaandroida.databinding.ItemEpisodeBinding
import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private val episodes by lazy { mutableListOf<EpisodeDisplayable>() }
    lateinit var onEpisodeClickListener: (EpisodeDisplayable) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBinding.inflate(inflater, parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode, onEpisodeClickListener)
    }

    fun setEpisodes(episodes: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) {
            this.episodes.clear()
        }

        this.episodes.addAll(episodes)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = episodes.size

    inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            episode: EpisodeDisplayable,
            onEpisodeClicked: (EpisodeDisplayable) -> Unit
        ) {
            with(binding) {
                item = episode
                root.setOnClickListener { onEpisodeClicked.invoke(episode) }
                executePendingBindings()
            }
        }
    }
}
