package com.monicals.monicalspizza


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentNutrition : Fragment() {

    var myNutritionURL: String = ""
    var loaded: Boolean = false

    private lateinit var viewOfLayout: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater.inflate(R.layout.fragment_fragment_nutrition, container, false)

        var nutritionWebView: WebView = viewOfLayout.findViewById(R.id.nutritionWebView)

        if (!loaded) {

            nutritionWebView.loadUrl(myNutritionURL)

        }

        val mWebSettings: WebSettings = nutritionWebView.settings
        mWebSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        mWebSettings.loadsImagesAutomatically = true
        mWebSettings.javaScriptEnabled = true
        nutritionWebView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                if(!loaded) {
                    nutritionWebView.loadUrl("javascript:jQuery('#nutracalc-modal').modal('show');")

                    loaded = true
                }
            }
        }


        // handle processing javascript to pop nutrition as MODEL
        return viewOfLayout
    }

    fun setNutritionURL(url: String)
    {
        myNutritionURL = url
    }

}
