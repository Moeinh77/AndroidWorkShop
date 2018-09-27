package com.example.moein.presentatiotest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.moein.presentatiotest.GSON.serverResponse
import com.example.moein.presentatiotest.volley.app
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import org.json.JSONObject

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signup_already_user.setOnClickListener{

            startActivity(intentFor<Login>())
            finish()

        }

        signup_signUpBtn.setOnClickListener{

            val username=signup_username.text.toString()
            val email=signup_userEmailId.text.toString()
            val mobile=signup_mobileNumber.text.toString()
            val location=signup_location.text.toString()
            val password=signup_password.text.toString()
            val confPassword=signup_confirmPassword.text.toString()

            signup(username,email,mobile,location,password,confPassword)

        }

    }

    private fun signup(username:String,
                             email:String,
                                mobile:String,
                                    location:String,
                                         password:String,
                                             confPassword:String) {


        val postReq= app.volleyObject

        val info=JSONObject()

        info.put("username",username)
        info.put("email",email)
        info.put("mobile",mobile)
        info.put("location",location)
        info.put("password",password)
        info.put("confPassword",confPassword)

        postReq.post("signup", info){response ->

            val res=app.Gson.fromJson(response.toString(),serverResponse::class.java)

            toast(res.message)

            if (res.status) {
                startActivity(intentFor<MainActivity>())
            }
        }

    }


}
