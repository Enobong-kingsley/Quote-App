package com.example.quoterapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class InspirationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_inspiration, container, false)

        val inspireNotification = view.findViewById<ImageView>(R.id.inspire_notification)
        val shareInspiration = view.findViewById<ImageView>(R.id.share_inspiration)

        inspireNotification.setOnClickListener {
            findNavController().navigate(R.id.notificationFragment)
        }
        shareInspiration.setOnClickListener {
            val inspirationQuote = view.findViewById<TextView>(R.id.inspiration_quote)
          val getInspirationQuote:String = inspirationQuote.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,getInspirationQuote)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"Share to :"))
        }

        return view

    }
}