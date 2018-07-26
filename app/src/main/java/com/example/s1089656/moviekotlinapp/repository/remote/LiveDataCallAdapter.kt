package com.example.s1089656.moviekotlinapp.repository.remote

import android.arch.lifecycle.LiveData
import android.content.Context
import com.example.s1089656.moviekotlinapp.model.FailureModel
import com.example.s1089656.moviekotlinapp.repository.remote.exception.ErrorMessageFactory
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by Ricardo Bravo on 23/07/18.
 */

class LiveDataCallAdapter<T>(private val c: Context,
                             private val responseType: Type) : CallAdapter<T, LiveData<T>> {

    override fun adapt(call: Call<T>): LiveData<T> =
            object : LiveData<T>() {

                val started: AtomicBoolean = AtomicBoolean(false)
                override fun onActive() {
                    super.onActive()
                    if (started.compareAndSet(false, true)) {
                        call.enqueue(object : Callback<T> {

                            override fun onResponse(call: Call<T>, response: Response<T>) {
                                postValue(response.body())
                            }

                            override fun onFailure(call: Call<T>, t: Throwable) {
                                postValue(FailureModel(ErrorMessageFactory.create(context = c, throwable = t)))
                            }

                        })
                    }
                }

            }

    override fun responseType(): Type = responseType

}