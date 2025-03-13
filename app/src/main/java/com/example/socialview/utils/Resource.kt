package com.example.socialview.utils


data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            var message: String? = null
            if (data == null) {
                message = "Body is null"
            }
            return Resource(Status.SUCCESS, data, message)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {

            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}