package com.ej.android_cleanarchitecture_newsapiclient.data.util

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    // We'll wrap our data in this 'Success'
    // class in case of success response from api
    class Success<T>(data: T) : Resource<T>(data = data)

    // We'll just pass object of this Loading
    // class, just before making an api call
    class Loading<T>(data: T? = null) : Resource<T>(data = data)

    // We'll pass error message wrapped in this 'Error'
    // class to the UI in case of failure response
    class Error<T>(errorMessage: String,data: T? = null) : Resource<T>(data = data,message = errorMessage)


}