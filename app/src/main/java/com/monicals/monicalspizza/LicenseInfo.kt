package com.monicals.monicalspizza

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LicenseInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        setContentView(R.layout.activity_license_info)


        val licenseWebView = findViewById<WebView>(R.id.licenseWebView)

        var licenseText = applicationContext.assets.open("MPC EULA.html").bufferedReader().use {
            it.readText()
        }

        licenseWebView.loadData(licenseText, "text/html; charset=UTF-8", null)

        var doneButton = findViewById(R.id.doneButton) as Button

        doneButton.setOnClickListener() {
            finish()
        }
    }
}
