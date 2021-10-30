package com.monicals.monicalspizza

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_web_ordering.*


class WebOrdering : AppCompatActivity() {

    val manager = supportFragmentManager
    var storeSelected = ""
    var orderURL = ""
    var giftURL = ""
    var nutritionURL = ""
    var fbProfile = ""



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_order -> {
                createFragmentOrder()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_giftcards -> {
                createFragmentGiftCards()
                return@OnNavigationItemSelectedListener true

            }
            R.id.navigation_fb -> {
                createFragmentFB()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_nutrition -> {
                createFragmentNutrition()
                return@OnNavigationItemSelectedListener true

            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_web_ordering)

        storeSelected = intent.getStringExtra("StoreSelected")
        orderURL = intent.getStringExtra("OrderURL")
        giftURL = intent.getStringExtra("GiftURL")
        fbProfile = intent.getStringExtra("FBProfile")
        nutritionURL = intent.getStringExtra("NutritionURL")
        /*var myTextView: TextView = findViewById(R.id.textView)
        myTextView.text = storeSelected*/

        createFragmentOrder()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    fun createFragmentOrder()
    {
        val transaction = manager.beginTransaction()
        val fragment = FragmentOrder()
        fragment.setStore(storeSelected, orderURL)
        transaction.replace(R.id.fragmentholder,fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentGiftCards()
    {
        val transaction = manager.beginTransaction()
        val fragment = FragmentGiftCards()
        fragment.setGiftURL(giftURL)
        transaction.replace(R.id.fragmentholder,fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentNutrition()
    {
        val transaction = manager.beginTransaction()
        val fragment = FragmentNutrition()
        fragment.setNutritionURL(nutritionURL)
        fragment.retainInstance = true
        transaction.replace(R.id.fragmentholder,fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentFB()
    {
        /*val transaction = manager.beginTransaction()
        val fragment = FragmentFB()
        transaction.replace(R.id.fragmentholder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()*/
        var theFB = fbProfile
        try {
            applicationContext!!.packageManager.getPackageInfo("com.facebook.katana", 0)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/$theFB"))
            startActivity(intent)
        } catch (e: Exception) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/$theFB"))
            startActivity(intent)
        }

    }
}