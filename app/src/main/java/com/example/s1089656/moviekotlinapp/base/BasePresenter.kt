package com.example.s1089656.moviekotlinapp.base

/**
 * Created by Ricardo Bravo on 23/07/2018.
 */

interface BasePresenter<T> {

    fun attach(view: T)
    fun dettach()

}