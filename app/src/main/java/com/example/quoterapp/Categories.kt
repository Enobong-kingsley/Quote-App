package com.example.quoterapp

import android.os.Bundle
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController


class Categories : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_categories, container, false)

        val inspirationCard = view.findViewById<CardView>(R.id.inspiration_card)
        val friendshipCard = view.findViewById<CardView>(R.id.friendship_card)
        val funnyCard = view.findViewById<CardView>(R.id.funny_card)
        val loveCard = view.findViewById<CardView>(R.id.love_card)
        val fearCard = view.findViewById<CardView>(R.id.fear_card)
        val datingCard = view.findViewById<CardView>(R.id.dating_card)
        val anniversaryCard = view.findViewById<CardView>(R.id.anniversary_card)

        inspirationCard.setOnClickListener {
            findNavController().navigate(R.id.inspirationFragment)
        }

        friendshipCard.setOnClickListener {
            findNavController().navigate(R.id.friendshipFragment)
        }

        funnyCard.setOnClickListener {
            findNavController().navigate(R.id.funnyFragment)
        }

        loveCard.setOnClickListener {
            findNavController().navigate(R.id.loveFragment)
        }

        fearCard.setOnClickListener {
            findNavController().navigate(R.id.fearFragment)
        }

        datingCard.setOnClickListener {
            findNavController().navigate(R.id.datingFragment)
        }

        anniversaryCard.setOnClickListener {
            findNavController().navigate(R.id.anniversaryFragment)
        }


        return view


    }


}