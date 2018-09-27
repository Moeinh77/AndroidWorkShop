package com.example.moein.presentatiotest.volley
import android.app.Application
import android.content.Context
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.moein.presentatiotest.tools_volley.VolleyObject
import com.google.gson.Gson


class app : Application() {

    companion object {

        private val TAG = app::class.java.simpleName

        lateinit var appcontext: Context
        lateinit var volleyObject: VolleyObject
        lateinit var Gson: Gson

        @get:Synchronized
        var instance: app? = null
            private set
    }

    val requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(applicationContext)
            }
            return field
        }

    override fun onCreate() {
        super.onCreate()

        instance = this
        appcontext = applicationContext
        volleyObject = VolleyObject()
        Gson = Gson()
    }

    fun <T> addToRequestQueue(request: Request<T>, tag: String) {
        request.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue?.add(request)
    }

    fun cancelVolleyRequsts(tag: Any) {
        if (requestQueue != null) {
            requestQueue!!.cancelAll(tag)
        }
    }


}