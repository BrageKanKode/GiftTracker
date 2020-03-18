package com.example.gifttracker.db


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.gifttracker.db.EventTable.COLUMN_ID
import com.example.gifttracker.db.EventTable.COLUMN_NAME

val DATABASE_VERSION: Int = 1
val DATABASE_NAME: String = "events_database"


open class BaseDataBase(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME, null,
    DATABASE_VERSION
) {

    override fun onCreate(db: SQLiteDatabase?) {
        val queryCreateStudentTable =
            "CREATE TABLE ${EventTable.TABLE_NAME} ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT )"
        db?.execSQL(queryCreateStudentTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}