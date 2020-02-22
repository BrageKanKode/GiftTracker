package com.example.gifttracker

import AppClasses.Persons
import android.app.Person
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_frag1.*
import kotlinx.android.synthetic.main.fragment_frag1.view.*


class Frag1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        lateinit var view: View
        view = inflater.inflate(R.layout.fragment_frag1, container, false)

        view.btnAddPerson.setOnClickListener {
             view = inflater.inflate(R.layout.fragment_register_person, container, false)
        }
        return view
    }
}
