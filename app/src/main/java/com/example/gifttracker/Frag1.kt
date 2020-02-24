package com.example.gifttracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return view
    }

}
