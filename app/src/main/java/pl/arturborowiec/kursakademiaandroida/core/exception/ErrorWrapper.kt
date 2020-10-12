package pl.arturborowiec.kursakademiaandroida.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}
