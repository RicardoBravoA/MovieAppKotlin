package com.example.s1089656.moviekotlinapp.repository.remote.exception

/**
 * Created by Ricardo Bravo on 24/07/18.
 */

interface ErrorBundle {

    fun getException(): Exception

    fun getErrorMessage(): String

}