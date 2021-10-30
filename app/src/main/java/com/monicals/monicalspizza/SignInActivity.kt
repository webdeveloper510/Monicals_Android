package com.monicals.monicalspizza

import android.accounts.AccountManagerCallback
import android.accounts.AccountManagerFuture
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.core.app.ActivityCompat.startActivityForResult
import com.google.gson.JsonObject
import java.io.IOException

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        hitSignAPI();
        hitTokenAPI();
    }

    private fun hitSignAPI() {
        val thread = Thread {
            try {
                val jsonObject = JsonObject()
                jsonObject.addProperty("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb2hhbjMzQGdtYWlsLmNvbSIsImV4cCI6MTYzNTU4MDM2NCwidG9rZW5fdHlwZSI6ImFjY2VzcyIsIm1lcmNoYW50IjoiTW9uaWNhbCdzIFBpenphIiwiY19pZCI6MTU2NzU4MjMsInoiOiIxb3FKN1gifQ.dotua4F7Wpb3ny1jx67K_gOAQtv7hnYDkFdOQpHCheSyE7qrTmVammrrFbGgaNzkI8lKDzmgB4Txb3GkyxX37Q\\")
                /*jsonObject.addProperty("password", "12345")
                jsonObject.addProperty("grant_type", "password")*/
                try {
                    val response = JsonUtil.requestSignIn(jsonObject)
                    Log.e("signIn_esponse", response.toString());

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

    private fun hitTokenAPI() {
        val thread = Thread {
            try {
                val jsonObject = JsonObject()
                jsonObject.addProperty("username", "sohan33@gmail.com")
                jsonObject.addProperty("password", "12345")
                jsonObject.addProperty("grant_type", "password")
                try {
                    val response = JsonUtil.requestToken(jsonObject)
                    Log.e("token_esponse", response.toString());

                } catch (e: IOException) {
                    e.printStackTrace()
                    Log.e("token_esponse", e.toString())

                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("token_esponse", e.toString())

            }
        }
        thread.start()
    }


}