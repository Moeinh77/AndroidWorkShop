package com.example.moein.presentatiotest.tools_volley

import com.example.moein.presentatiotest.volley.VolleyRequestInside
import org.json.JSONObject

/**
 * Created by Moein on 5/3/2018.
 */
class VolleyObject : ServiceInterface {

    private val service = VolleyRequestInside()

    override fun post(action: String, completionHandler: (response: JSONObject?) -> Unit) {
        service.post(action, completionHandler)
    }

    override fun post(action: String, params: JSONObject?, completionHandler: (response: JSONObject?) -> Unit) {
        service.post(action, params, completionHandler)
    }
}


