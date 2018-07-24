package com.example.s1089656.moviekotlinapp.di.annotations

import javax.inject.Scope

/**
 * Created by Ricardo Bravo on 23/07/2018.
 */

@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FILE,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER)
annotation class FragmentScoped