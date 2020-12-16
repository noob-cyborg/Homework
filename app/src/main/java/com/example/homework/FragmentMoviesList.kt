package com.example.homework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {

    private var myFragmentListener: MyFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<CardView>(R.id.cardMovie).setOnClickListener {
            myFragmentListener?.changeToFragmentDetails()
        }
    }

    override fun onDetach() {
        super.onDetach()
        myFragmentListener = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MyFragmentListener) {
            myFragmentListener = context
        }
    }
}