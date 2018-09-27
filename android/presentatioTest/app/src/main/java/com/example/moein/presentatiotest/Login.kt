package com.example.moein.presentatiotest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.moein.presentatiotest.GSON.serverResponse
import com.example.moein.presentatiotest.volley.app
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import org.json.JSONObject

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtn.setOnClickListener{

            val username=login_username.text.toString()
            val password=login_password.text.toString()

            login(username,password)

        }

    }

    fun login(username:String, password:String){

        val postReq= app.volleyObject

        val info=JSONObject()
        info.put("username", username)
        info.put("password", password)

        postReq.post("login",info){response ->

            val res=app.Gson.fromJson(response.toString(), serverResponse::class.java)

            toast(res.message)

        }

    }

}
