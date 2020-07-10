package com.example.gifttracker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_frag1.view.*


class Frag1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_frag1, container, false)

        val preferences =
            this.activity!!.getSharedPreferences("pref", Context.MODE_PRIVATE)

        view.btnAddEvent.setOnClickListener {
            requireActivity().startActivity(
                Intent(requireActivity(), Main2Activity::class.java)
            )
        }
        return view
    }

}
