package com.example.gifttracker

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gifttracker.database.EventsDTO
import com.example.gifttracker.db.EventsDAO
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.fragment_frag1.*

class Main2Activity : AppCompatActivity() {

    //private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val studentDb = EventsDAO(this)
        val adapter = EventsAdapter(this) { EventsDTO ->
            showAlertDialogWith(EventsDTO)
        }

        btnSaveEvent.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            /*
            // Create a shared preference instance
            sharedPreferences = getSharedPreferences("com.example.gifttracker", Context.MODE_PRIVATE)


            // create editor and add the key value pair to the preference
            val editor = sharedPreferences.edit()
            editor.putString("KEY_STR", editText2.text.toString())
            editor.apply()


            val str = sharedPreferences.getString("KEY_STR", null)
            //Toast.makeText(this, str, Toast.LENGTH_LONG).show()
             */

            //Save to database
            // Get value from the edit text (edit_name)
            val nameText = editText2.text.toString()
            // Save it to DB
            val rowId = studentDb.insert(nameText)
            Toast.makeText(this, "Stored $nameText in $rowId", Toast.LENGTH_SHORT).show()

            val list = studentDb.fetchAll()
            adapter.setStudentsList(list)

        }

        var recyclerview = findViewById<RecyclerView>(R.id.textViewFrag1)
        recyclerview.layoutManager = GridLayoutManager(this, 2)
        recyclerview.adapter = adapter

        val list = studentDb.fetchAll()
        adapter.setStudentsList(list)
    }



    private fun showAlertDialogWith(studentDTO: EventsDTO) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("What do you wanna do?")
        builder.setNegativeButton("DELETE", DialogInterface.OnClickListener { dialog, which ->
            // Delete the row
        })

        builder.setPositiveButton("Update", DialogInterface.OnClickListener { dialog, which ->
            // Update the row
        })

        val alertDialog = builder.create()
        alertDialog.show()

    }
}
