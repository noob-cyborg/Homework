package com.example.homework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {

    private var myFragmentListener: MyFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_movie_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.back_text).setOnClickListener {
            myFragmentListener?.changeToFragmentList()
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
