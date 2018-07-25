package com.example.s1089656.moviekotlinapp.repository.remote.exception

import android.content.Context
import retrofit2.HttpException
import java.io.IOException


/**
 * Created by Ricardo Bravo on 24/07/18.
 */

class ErrorMessageFactory {

    fun create(context: Context, throwable: Throwable): String {
        val retrofitException = asRetrofitException(context, throwable)
        return retrofitException.message!!
    }

    fun createWithCode(context: Context, throwable: Throwable): RetrofitException {
        return asRetrofitException(context, throwable)
    }

    private fun asRetrofitException(context: Context, throwable: Throwable): RetrofitException {
        if (throwable is HttpException) {
            val response = throwable.response()

            return RetrofitException.httpError(context, response.raw().request().url().toString(),
                    response, null)
        }
        if (throwable is NetworkConnectionException) {
            return RetrofitException.networkError(context, throwable)
        }

        return if (throwable is IOException) {
            RetrofitException.unexpectedError(context, throwable)
        } else RetrofitException.unexpectedError(context, throwable)

    }
}