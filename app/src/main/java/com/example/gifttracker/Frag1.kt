package com.example.gifttracker

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gifttracker.database.EventsDTO
import com.example.gifttracker.db.EventsDAO
import kotlinx.android.synthetic.main.fragment_frag1.*
import kotlinx.android.synthetic.main.fragment_frag1.view.*


class Frag1 : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_frag1, container, false)

        view.btnAddEvent.setOnClickListener {
            requireActivity().startActivity(
                Intent(requireActivity(), Main2Activity::class.java)
            )
        }


        /*
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        val editor = sharedPreferences?.edit()
        editor?.putString("latitude", "Test")?.apply()


        val text = sharedPreferences?.getString("longitude","Longitude doesn't exist")


        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()


        val str = sharedPreferences?.getString("KEY_STR", null)
        Toast.makeText(context, str, Toast.LENGTH_LONG).show()

        textViewFrag1?.text = str



         */
    val studentDb = EventsDAO(this.requireContext())
    val adapter = EventsAdapter(this.requireContext()) {}



        view.textViewFrag1.layoutManager = GridLayoutManager(context, 1)
        view.textViewFrag1.adapter = adapter

        val list = studentDb.fetchAll()
        adapter.setStudentsList(list)
        return view

    }

}
