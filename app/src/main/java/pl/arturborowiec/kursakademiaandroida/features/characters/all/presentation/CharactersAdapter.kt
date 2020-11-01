package pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_character.view.*
import pl.arturborowiec.kursakademiaandroida.databinding.ItemCharacterBinding
import pl.arturborowiec.kursakademiaandroida.databinding.ItemEpisodeBinding
import pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters by lazy { mutableListOf<CharacterDisplayable>() }
    lateinit var onCharacterClickListener: (CharacterDisplayable) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, onCharacterClickListener)
    }

    fun setCharacters(characters: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) {
            this.characters.clear()
        }

        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = characters.size

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            character: CharacterDisplayable,
            onCharacterClicked: (CharacterDisplayable) -> Unit
        ) {
            with(binding) {
                item = character

                Glide.with(this.root)
                    .load(character.image)
                    .into(imageView)

                root.setOnClickListener { onCharacterClicked.invoke(character) }
                executePendingBindings()
            }
        }
    }
}
