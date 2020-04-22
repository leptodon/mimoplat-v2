package ru.mimobaka.mimoplat_v3.model

sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(
        val error: Throwable,
        val message: String = error.message ?: "Error unknown"
    ) : Result<Nothing>()
}