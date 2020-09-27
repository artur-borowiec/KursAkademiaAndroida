package pl.arturborowiec.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.arturborowiec.kursakademiaandroida.core.base.BaseViewModel
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.Character
import pl.arturborowiec.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable

class CharacterViewModel(private val getCharactersUseCase: GetCharactersUseCase) : BaseViewModel() {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    val characters by lazy {
        _characters.map { characters ->
            characters.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(characterLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharactersUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { characterLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}
