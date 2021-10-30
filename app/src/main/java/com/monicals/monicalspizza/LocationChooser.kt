package com.monicals.monicalspizza

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.NumberPicker
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_location_chooser.*

class LocationChooser : AppCompatActivity() {

    var pickerData: Array<String> = emptyArray()
    lateinit var picker: NumberPicker
    lateinit var db: SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = DatabaseHelper(this).openDatabase()


        setContentView(R.layout.activity_location_chooser)

        picker = findViewById(R.id.storePicker)
        var initialData = arrayOf("Select Your Store")
        pickerData = initialData

        /*var cb: Button = findViewById(R.id.continueButton)
        cb.isEnabled = false*/


        var licenseButton = findViewById(R.id.licenseButton) as ImageButton
        licenseButton.setOnClickListener {
            val intent = Intent(this, LicenseInfo::class.java)
            startActivity(intent)
        }


        var clubButton = findViewById(R.id.dippinclub) as ImageButton
        clubButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.monicals.com/phpList/"))
            startActivity(intent);
        }

        var results: Cursor = db.rawQuery("SELECT * FROM stores", null)
        results.moveToFirst()
        while(!results.isAfterLast())
        {
            pickerData = pickerData.plusElement(results.getString(results.getColumnIndex("display_name")))
            results.moveToNext()
        }

        picker.minValue = 0
        picker.maxValue = pickerData.size - 1
        picker.displayedValues = pickerData

        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        val savedStore = sharedPref.getString("store_name_key", "")
        if(savedStore != "") {
            val position = pickerData.indexOf(savedStore)
            picker.value = position
        }

        //addListenerOnPicker();

        var continueButton: Button = findViewById(R.id.continueButton)
        continueButton.setOnClickListener() {
            if(pickerData[picker.value] != "Select Your Store") {

                val sharedPref = getPreferences(Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("store_name_key",pickerData[picker.value])
                    editor.apply()


                val intent = Intent(this, WebOrdering::class.java).apply {
                    var url: Cursor =
                        db.rawQuery("SELECT * FROM stores WHERE display_name = ?", arrayOf(pickerData[picker.value]))
                    url.moveToFirst()

                    var theURL = url.getString(url.getColumnIndex("order_url"))
                    var giftURL = url.getString(url.getColumnIndex("gift_url"))
                    var fbProfile = url.getString(url.getColumnIndex("FB_Profile"))
                    var nutritionURL = url.getString(url.getColumnIndex("location_url"))
                    putExtra("StoreSelected", pickerData[picker.value])
                    putExtra("OrderURL", theURL)
                    putExtra("GiftURL", giftURL)
                    putExtra("FBProfile", fbProfile)
                    putExtra("NutritionURL", nutritionURL)
                }
                startActivity(intent)
            }
        }

    }

   /*   fun addListenerOnPicker(){
        picker.setOnValueChangedListener { picker, oldVal, newVal ->
          /*  if(newVal == 0)
            {
                var cb: Button = findViewById(R.id.continueButton)
                cb.isEnabled = false
            }*/
        }
    }*/

    fun onStateFilterClicked(view: View) {

        // handle state filter change here.
        // var checked = RadioButton(this).isChecked()
        var manager: LocationManager = LocationManager(db)

        when(view.id) {
            R.id.filter_all -> {
                pickerData = emptyArray()
                pickerData = manager.getStoresByState("ALL")

                picker.displayedValues = null
                picker.minValue = 0
                picker.maxValue = pickerData.size - 1
                picker.displayedValues = pickerData
                picker.value = 0

                return
            }
            R.id.filter_IL -> {
                pickerData = emptyArray()
                pickerData = manager.getStoresByState("IL")

                picker.displayedValues = null
                picker.minValue = 0
                picker.maxValue = pickerData.size - 1
                picker.displayedValues = pickerData
                picker.value = 0

                return
            }
            R.id.filter_IN -> {
                    pickerData = emptyArray()
                    pickerData = manager.getStoresByState("IN")

                    picker.displayedValues = null
                    picker.minValue = 0
                    picker.maxValue = pickerData.size - 1
                    picker.displayedValues = pickerData
                    picker.value = 0

                    return
            }
            R.id.filter_MO -> {
                    pickerData = emptyArray()
                    pickerData = manager.getStoresByState("MO")

                    picker.displayedValues = null
                    picker.minValue = 0
                    picker.maxValue = pickerData.size - 1
                    picker.displayedValues = pickerData
                    picker.value = 0

                    return
            }
            R.id.filter_WI -> {
                    pickerData = emptyArray()
                    pickerData = manager.getStoresByState("WI")

                    picker.displayedValues = null
                    picker.minValue = 0
                    picker.maxValue = pickerData.size - 1
                    picker.displayedValues = pickerData
                    picker.value = 0

                    return
            }
        }
    }
}
