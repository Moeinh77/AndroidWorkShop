package com.example.moein.presentatiotest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.moein.presentatiotest.volley.app
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private val TAG = "My-MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v(TAG,"Inside the MainActivity")

        toast(intent.getStringExtra("username"))

        showMyinfo(intent.getStringExtra("username"))

    }

    fun showMyinfo(username:String){

        val info=JSONObject()
        info.put("username",username)

        app.volleyObject.post("userInfo",info){

            val infoArr=parseInfo(it!!.getJSONObject("message").toString())

            for (i in 0 until infoArr.size)
                userInfo_txt.append(infoArr[i]+"\n")

        }

    }

    fun parseInfo(info:String):List<String>{

        val infoArr=info
                .replace("{", "")
                .replace("}","")
                .replace("\""," ")
                .split(",")

        return infoArr

    }
}
