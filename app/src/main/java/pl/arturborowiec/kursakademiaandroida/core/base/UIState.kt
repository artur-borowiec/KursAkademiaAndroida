package pl.arturborowiec.kursakademiaandroida.core.base

sealed class UIState {
    object Idle : UIState()
    object Pending : UIState()
}
