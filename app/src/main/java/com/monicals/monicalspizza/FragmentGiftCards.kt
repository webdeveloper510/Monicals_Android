package com.monicals.monicalspizza


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentGiftCards : Fragment() {

    var myGiftURL: String = ""
    private lateinit var viewOfLayout: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater.inflate(R.layout.fragment_fragment_gift_cards, container, false)

        var giftWebView: WebView = viewOfLayout.findViewById(R.id.giftWebView)
        giftWebView.loadUrl(myGiftURL)

        val mWebSettings: WebSettings = giftWebView.settings
        /*mWebSettings.domStorageEnabled = true
        mWebSettings.setAppCacheEnabled(true)*/
        mWebSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        mWebSettings.loadsImagesAutomatically = true
        mWebSettings.javaScriptEnabled = true
        giftWebView.webViewClient = WebViewClient()
        return viewOfLayout
    }

    fun setGiftURL(url: String)
    {
        myGiftURL = url
    }

}
