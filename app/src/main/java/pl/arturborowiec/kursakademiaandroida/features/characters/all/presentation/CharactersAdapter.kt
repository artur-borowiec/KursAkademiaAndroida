package pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_character.view.*
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters by lazy { mutableListOf<CharacterDisplayable>() }
    lateinit var onCharacterClickListener: (CharacterDisplayable) -> Unit

    fun setCharacters(characters: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) {
            this.characters.clear()
        }

        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_character, parent, false)

        return CharacterViewHolder(itemView)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, onCharacterClickListener)
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            character: CharacterDisplayable,
            onCharacterClicked: (CharacterDisplayable) -> Unit
        ) {
            with(itemView) {
                Glide.with(this)
                    .load(character.image)
                    .into(imageView)

                textView.text = character.name

                setOnClickListener { onCharacterClicked.invoke(character) }
            }
        }
    }
}
