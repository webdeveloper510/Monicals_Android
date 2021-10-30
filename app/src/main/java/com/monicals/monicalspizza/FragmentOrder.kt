package com.monicals.monicalspizza


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_fragment_order.*
import kotlinx.android.synthetic.main.fragment_fragment_order.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentOrder : Fragment() {

    var myStore: String = ""
    var myURL: String = ""
   private lateinit var viewOfLayout: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //orderingStore.setText("Hello there!!")
        // Inflate the layout for this fragment
        viewOfLayout = inflater.inflate(R.layout.fragment_fragment_order, container, false)

        var webView: WebView = viewOfLayout.findViewById(R.id.webview)
        webView.loadUrl(myURL)

        val mWebSettings: WebSettings = webView.settings
        mWebSettings.javaScriptEnabled = true
        mWebSettings.domStorageEnabled = true
        mWebSettings.setAppCacheEnabled(true)

       // WebView.setWebContentsDebuggingEnabled(true)


        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request!!.url.toString()

                if (url.startsWith("http:") || url.startsWith("https:")) {
                    view!!.loadUrl(url)
                    return false
                }

                // Fix to handle tel: links outside the built-in application web ordering browser.
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                return true
            }

        }

        return viewOfLayout
    }

    fun setStore(store: String, url: String)
    {
        myStore = store
        myURL = url
        /*orderingStore = store
        //var view: View? = getView()?.findViewById(R.id.orderingStore)
        var selected: TextView? = getView()?.findViewById(R.id.orderingStore)

        selected?.text = "Ordering from $orderingStore"*/
    }


}
