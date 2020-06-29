package fr.haan.bamprojects.data.model

sealed class State<out T> {

    open operator fun invoke(): T? = null

    data class Success<T>(val data: T) : State<T>() {
        override operator fun invoke(): T = data
    }

    data class Error<T>(val error: String) : State<T>()

}