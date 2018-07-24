package com.example.s1089656.moviekotlinapp.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by Ricardo Bravo on 23/07/2018.
 */

@Module
abstract class ApplicationModule {
    @Binds
    internal abstract fun provideContext(application: Application): Context
}