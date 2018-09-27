package com.example.moein.presentatiotest.tools_volley

import org.json.JSONObject

/**
 * Created by Moein on 5/3/2018.
 * model e request dahi ma inja neveshte shode ke path address server ast va
 * completionHandler response server rabe ma midahad
 ***
 *  inja ra badan mitavanim taghir dahim baraye estefade balibrary digari
 */
interface ServiceInterface {

    fun post(action: String, params: JSONObject?, completionHandler: (response: JSONObject?) -> Unit)

}