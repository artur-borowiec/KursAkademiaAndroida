package pl.arturborowiec.kursakademiaandroida.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}
