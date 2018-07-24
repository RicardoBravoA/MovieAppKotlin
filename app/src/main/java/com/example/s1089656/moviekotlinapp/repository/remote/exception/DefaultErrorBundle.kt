package com.example.s1089656.moviekotlinapp.repository.remote.exception

/**
 * Created by Ricardo Bravo on 24/07/18.
 */

class DefaultErrorBundle : ErrorBundle {

    private val DEFAULT_ERROR_MSG = "Unknown error"

    private var exception: Exception

    constructor(exception: Exception) {
        this.exception = exception
    }

    override fun getException(): Exception {
        return exception
    }

    override fun getErrorMessage(): String {
        return if (exception != null && exception.message != null) exception.message!! else DEFAULT_ERROR_MSG
    }


}