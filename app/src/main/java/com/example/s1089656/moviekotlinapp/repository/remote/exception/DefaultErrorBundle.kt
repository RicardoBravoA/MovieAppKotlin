package com.example.s1089656.moviekotlinapp.repository.remote.exception

/**
 * Created by Ricardo Bravo on 24/07/18.
 */

class DefaultErrorBundle(private val exception: Exception) : ErrorBundle {

    private val DEFAULT_ERROR_MSG = "Unknown error"

    override fun getException(): Exception {
        return exception
    }

    override fun getErrorMessage(): String {
        return if (exception != null && exception.message != null) exception.message!! else DEFAULT_ERROR_MSG
    }


}