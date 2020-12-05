package com.example.quoterapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class GetStarted : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     val view = inflater.inflate(R.layout.fragment_get_started, container, false)
       val startButton= view.findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_getStarted_to_categories) }
        return view
    }

}