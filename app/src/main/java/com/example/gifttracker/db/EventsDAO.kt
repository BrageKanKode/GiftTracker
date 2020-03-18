package com.example.gifttracker.db


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.provider.BaseColumns
import com.example.gifttracker.database.EventsDTO
import com.example.gifttracker.db.EventTable.COLUMN_ID
import com.example.gifttracker.db.EventTable.COLUMN_NAME
import com.example.gifttracker.db.EventTable.TABLE_NAME


object EventTable : BaseColumns {
    val TABLE_NAME = "event_table"
    val COLUMN_NAME = "name"
    val COLUMN_ID = "_id"
}

class EventsDAO(context: Context) : BaseDataBase(context) {

    fun insert(name: String): Long? {

        /*val query = " INSERT INTO $TABLE_NAME_STUDENTS ($COLUMN_NAME) VALUES ('$name')"
        writableDatabase.execSQL(query)*/

        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
        }

        return writableDatabase.use {
            it.insert(TABLE_NAME, null, values)
        }
        return 0
    }

    fun update(student: EventsDTO): Int? {
        val values = ContentValues().apply {
            put(COLUMN_NAME, student.name)
        }

        val selection = "$COLUMN_ID = ?"
        val selectionArgs = arrayOf(student.id.toString())

        return writableDatabase.use {
            it.update(TABLE_NAME, values, selection, selectionArgs)
        }
    }

    fun fetchAll(): List<EventsDTO> {


        val cursor: Cursor = readableDatabase.query(TABLE_NAME, null, null, null, null, null, null)
        val studentsList = mutableListOf<EventsDTO>()
        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow(COLUMN_ID))
                val name = getString(getColumnIndexOrThrow(COLUMN_NAME))
                studentsList.add(EventsDTO(id, name))
            }
        }
        return studentsList
    }

    fun delete(id: Long) {

    }
}