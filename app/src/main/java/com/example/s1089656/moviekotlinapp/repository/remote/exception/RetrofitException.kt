package com.example.s1089656.moviekotlinapp.repository.remote.exception

import android.content.Context
import com.example.s1089656.moviekotlinapp.R
import com.example.s1089656.moviekotlinapp.model.ErrorModel
import retrofit2.Response
import java.io.IOException
import retrofit2.Retrofit
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Converter


/**
 * Created by Ricardo Bravo on 24/07/18.
 */

class RetrofitException(private val msg: String?,
                        private val url: String?,
                        private val response: Response<*>?,
                        private val kind: Kind,
                        private val exception: Throwable?,
                        private val retrofit: Retrofit?) : RuntimeException(msg, exception) {

    companion object {

        fun httpError(context: Context, url: String, response: Response<*>, retrofit: Retrofit?): RetrofitException {
            var errorBody = ""

            var errorModel: ErrorModel? = null

            try {
                errorBody = response.errorBody()!!.string()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            try {
                errorModel = Gson().fromJson<ErrorModel>(errorBody, ErrorModel::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            if (errorModel == null) {
                errorModel = ErrorModel(999, context.getString(R.string.exception_message_generic),
                        false)
            }

            return RetrofitException(errorModel.statusMessage, url, response, Kind.HTTP, null, retrofit)
        }

        fun networkError(context: Context, exception: IOException): RetrofitException {
            return RetrofitException(context.getString(R.string.exception_message_there_is_not_connection),
                    null, null, Kind.NETWORK, exception, null)
        }

        fun unexpectedError(context: Context, exception: Throwable): RetrofitException {
            return RetrofitException(context.getString(R.string.exception_message_generic), null, null,
                    Kind.UNEXPECTED, exception, null)
        }

    }

    fun errorMessage() = msg

    @Throws(IOException::class)
    fun <T> getErrorBodyAs(type: Class<T>): T? {
        if (response?.errorBody() == null || retrofit == null) {
            return null
        }

        val converter: Converter<ResponseBody, T> =
                retrofit.responseBodyConverter(type, arrayOfNulls<Annotation>(0))
        return converter.convert(response.errorBody())
    }

    enum class Kind {
        NETWORK,
        HTTP,
        UNEXPECTED
    }


}