package com.example.s1089656.moviekotlinapp.repository.remote

import android.content.Context
import com.example.s1089656.moviekotlinapp.repository.remote.exception.DefaultErrorBundle
import com.example.s1089656.moviekotlinapp.repository.remote.exception.ErrorMessageFactory

/**
 * Created by Ricardo Bravo on 23/07/18.
 */

class FailureResponse {

    fun create(context: Context, throwable: Throwable): String {

        val errorBundle = DefaultErrorBundle(throwable as Exception)
        return ErrorMessageFactory.create(context, errorBundle.getException())
    }

}