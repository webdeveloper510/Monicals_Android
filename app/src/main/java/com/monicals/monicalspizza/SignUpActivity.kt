package com.monicals.monicalspizza

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonObject
import java.io.IOException

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initUI();
        hitSignUpAPI();
    }

    private fun initUI() {
        TODO("Not yet implemented")
    }

    private fun hitSignUpAPI() {
        val thread = Thread {
            try {
                val jsonObject = JsonObject()
                jsonObject.addProperty("name", "Jo4h4n77nyp444pp")
                jsonObject.addProperty("email", "sd44fgh4g79771.pjke@example.com")
                jsonObject.addProperty("password", "12345")
                jsonObject.addProperty("sendNewsletters",true)
                jsonObject.addProperty("phone", "573-003-9080")
                jsonObject.addProperty("store", "Avon")
                try {
                    val response = JsonUtil.requestSignUP(jsonObject)

                    //     Log.e("tgkjbhnj",subCatModels.toString());
                    val data: ByteArray = JsonUtil.gson().fromJson(response, ByteArray::class.java)

                    Log.e("signup_esponse", response.toString()+" data "+data)

                } catch (e: IOException) {
                    e.printStackTrace()
                    Log.e("signup_esponse", e.toString())

                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("signup_esponse", e.toString())

            }
        }
        thread.start()
    }
}