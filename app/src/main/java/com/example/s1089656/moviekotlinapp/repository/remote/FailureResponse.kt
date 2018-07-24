package com.example.s1089656.moviekotlinapp.repository.remote

import com.example.s1089656.moviekotlinapp.repository.remote.exception.DefaultErrorBundle
import com.example.s1089656.moviekotlinapp.repository.remote.exception.DefaultErrorBundle





/**
 * Created by Ricardo Bravo on 23/07/18.
 */

class FailureResponse<T> {

    var errorMessage: String

    constructor(throwable: Throwable) {

        val errorBundle = DefaultErrorBundle(throwable as Exception)
        val retrofitException = ErrorMessageFactory
                .createWithCode(onboardingStep1View.context(), errorBundle.getException())

        LogUtil.i("z- error", throwable.toString())

        val code = String.valueOf(retrofitException.getResponseCode())

        if (code == Constant.CODE_DOI_1 || code == Constant.CODE_DOI_2) {
            count++

            if (count === 3) {
                onboardingStep1View.showErrorClose(onboardingStep1View.context().getString(R.string.message_onboarding_doi))
            } else {
                onboardingStep1View.showError(retrofitException.getMessage())
            }
        } else {
            onboardingStep1View.showError(retrofitException.getMessage())
        }



    }

}