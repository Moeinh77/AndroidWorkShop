package com.example.moein.presentatiotest.volley

import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.moein.presentatiotest.tools_volley.ServiceInterface
import org.json.JSONObject

class VolleyRequestInside : ServiceInterface {

    val TAG = "My-Volley"

    val url = "http://192.168.1.9/main.php"

    override fun post(action: String, params: JSONObject?, completionHandler:
    (response: JSONObject?) -> Unit) {

        params?.put("action",action)

        val jsonObjReq = object : JsonObjectRequest(Method.POST, url, params,
                Response.Listener<JSONObject> { response ->
                    Log.v(TAG, "/post request OK! Response: $response")
                    completionHandler(response)
                },
                Response.ErrorListener { error ->
                    Log.v(TAG, "/post request fail! Error: ${error.message}")
                    completionHandler(null)
                }) {

//            override fun getHeaders(): MutableMap<String, String> {
//                val headers = HashMap<String, String>()
//                return headers
//            }
        }

        app.instance?.addToRequestQueue(jsonObjReq, TAG)
    }


}
