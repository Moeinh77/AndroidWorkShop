package com.example.moein.presentatiotest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.moein.presentatiotest.GSON.signupRes
import com.example.moein.presentatiotest.volley.app
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.toast
import org.json.JSONObject

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val fullName=signup_fullName.text.toString()
        val email=signup_userEmailId.text.toString()
        val mobile=signup_mobileNumber.text.toString()
        val location=signup_location.text.toString()
        val password=signup_password.text.toString()
        val confPassword=signup_confirmPassword.text.toString()

        signup(fullName,email,mobile,location,password,confPassword)


    }

    private fun signup(fullname:String,
                             email:String,
                                mobile:String,
                                    location:String,
                                         password:String,
                                             confPassword:String) {


        val postReq= app.volleyObject

        val info=infoFunc(fullname,email,mobile,location,password,confPassword)

        postReq.post("signUp", info){response ->

            val res=app.Gson.fromJson(response.toString(),signupRes::class.java)

            toast(res.toString())

        }

    }


    fun <T> infoFunc(vararg infos: T): JSONObject {

        val infoObj=JSONObject()

        for (i in infos)
            infoObj.put("$i",i)

        return infoObj
    }

}
