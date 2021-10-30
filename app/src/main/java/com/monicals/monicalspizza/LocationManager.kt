package com.monicals.monicalspizza

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class LocationManager {
    var db: SQLiteDatabase
    //var storeData = null
    //var storeURLs = null


    constructor(database: SQLiteDatabase) {
        db = database
    }

    fun getStoresByState(state : String): Array<String> {
        when(state) {
            "MO" ->
                return arrayOf("Select Your Store", "O'Fallon, MO")
            "IN" ->
                return arrayOf("Select Your Store","Avon, IN", "Delphi, IN", "Fishers, IN", "Greencastle, IN",
                    "Kentland, IN", "Lafayette, IN", "Linton, IN", "Monticello, IN", "Terre Haute: Towne South Ctr",
                    "Terre Haute: Sycamore Terrace", "Indianapolis: Traders Point",
                    "Vincennes, IN", "West Lafayette, IN")
            "WI" ->
                return arrayOf("Select Your Store", "Arbor Vitae, WI")
            "IL" -> {
                var data: Array<String> = arrayOf("Select Your Store")

                var results: Cursor = db.rawQuery("SELECT * FROM stores WHERE state = \"IL\"", null)
                results.moveToFirst()
                while (!results.isAfterLast()) {
                    data = data.plusElement(results.getString(results.getColumnIndex("display_name")))
                    results.moveToNext()
                }

                return data
            }
            "ALL" -> {
                var data: Array<String> = arrayOf("Select Your Store")

                var results: Cursor = db.rawQuery("SELECT * FROM stores", null)
                results.moveToFirst()
                while (!results.isAfterLast()) {
                    data = data.plusElement(results.getString(results.getColumnIndex("display_name")))
                    results.moveToNext()
                }

                return data
            }
        }

        return arrayOf("Select Your Store")
    }


/*    var db = null
    var dbh = null

    constructor(db : DatabaseHelper)
    {
        this.db = db
        this.dbh = db.openDatabase()
    }

    fun getStoresByState(state : String): Array<String> {

        var dbCursor: Cursor = this.dbh.query("stores", "display_name", "state = ?", state)
        dbCursor.moveToFirst()
        do {
            print(dbCursor.getString(dbCursor.getColumnIndex("display_name")))
        } while(dbCursor.moveToNext())

        */
        /*

        var storeStates = when(state) {
            "MO" -> arrayOf("Select Your Store", "O'Fallon, MO")

            "IN" -> arrayOf(
                "Select Your Store", "Avon, IN", "Delphi, IN", "Fishers, IN", "Greencastle, IN",
                "Kentland, IN", "Lafayette, IN", "Linton, IN", "Monticello, IN", "Terre Haute: Towne South Ctr",
                "Terre Haute: Sycamore Terrace", "Indianapolis: Southport Rd", "Indianapolis: Traders Point",
                "Vincennes, IN", "West Lafayette, IN"
            )

            // todo ... add IL and ALL

            "WI" -> arrayOf("Select Your Store", "Arbor Vitae, WI")


            else -> {
                arrayOf("Select Your Store")
            }
        }

        return storeStates
    }*/
}