package com.example.gifttracker

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gifttracker.data.ExampleItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main2.*
import java.lang.reflect.Type

class Main2Activity : AppCompatActivity() {

    private var mExampleList: ArrayList<ExampleItem>? = null
    private val mAdapter: ExampleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        loadData()




        btnSaveEvent.setOnClickListener {





            val line1 : Editable? = editView_set_event_name.text
            val line2 : Editable? = editText_date.text


            saveData(line1.toString(), line2.toString())




            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
        }

    }

    private fun saveData(line1: String, line2: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("Shared preferences", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        mExampleList?.add(ExampleItem(line1, line2))
        mAdapter?.notifyItemInserted(mExampleList!!.size)
        val gson: Gson = Gson()
        val json: String? = gson.toJson(mExampleList)
        editor.putString("task list", json)
        editor.apply()

        Toast.makeText(this, "Saved $line1", Toast.LENGTH_LONG).show()
    }


    private fun loadData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("Shared preferences", MODE_PRIVATE)
        val gson = Gson()
        val json: String? = sharedPreferences.getString("task list", null)

        val type: Type  = object: TypeToken<ArrayList<ExampleItem>>() {}.type
        mExampleList = gson.fromJson(json, type)





        if(mExampleList == null) {
            mExampleList = ArrayList()
        }

        var temp: String? = null
       mExampleList!!.forEach {

           if(temp == null){
                temp = it.Title + "\n"
           } else {
               temp += it.Title + "\n"
           }


        }
           textViewTest.text = temp
    }

}
