package com.example.gifttracker

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnSaveEvent.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)

            // Create a shared preference instance
            sharedPreferences = getSharedPreferences("com.example.gifttracker", Context.MODE_PRIVATE)


            // create editor and add the key value pair to the preference
            val editor = sharedPreferences.edit()
            editor.putString("KEY_STR", editText.text.toString())
            editor.apply()


            val str = sharedPreferences.getString("KEY_STR", null)
            Toast.makeText(this, str, Toast.LENGTH_LONG).show()

        }

    }



        /*

        btn_delete_preference.setOnClickListener {
            // create editor and remove the key value pair form the preference
            val editor = sharedPreferences.edit()
            editor.remove("KEY_STR")
            editor.apply()
        }

         */
}
