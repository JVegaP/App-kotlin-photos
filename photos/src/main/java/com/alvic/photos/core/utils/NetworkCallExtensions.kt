package com.alvic.photos.core.utils

import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import java.lang.NullPointerException

suspend fun <T: Any> apiCall(
    call: suspend () -> Result<T>,
    errorMessage: String
): Result<T> = try {
    call.invoke()
} catch (e: Exception) {
    Result.Error(IOException(errorMessage, e))
}

fun <T: Any> Response<T>.callService(): Result<T> {
    return if(this.body()!=null) {
        Result.Success(this.body() as T)
    }else {
        Result.Error(NullPointerException(this.errorBody().toString()))
    }
}