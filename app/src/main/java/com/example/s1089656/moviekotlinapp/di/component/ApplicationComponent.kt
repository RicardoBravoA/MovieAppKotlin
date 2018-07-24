package com.example.s1089656.moviekotlinapp.di.component

import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ricardo Bravo on 20/07/2018.
 */

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ActivityBindingModule::class,
    RetrofitModule::class,
    AndroidSupportInjectionModule::class,
    UserRepositoryModule::class
])
interface AppComponent : AndroidInjector<SampleApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}