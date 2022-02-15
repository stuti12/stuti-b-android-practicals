package com.example.myapplication.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_view_message.displayMessage

class ViewMessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_view_message, container, false)
        val displayM:TextView = view.findViewById(R.id.displayMessage)
        val model = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        /* other way for data reciving
        displayMessage = arguments?.getString("message")
        displayM.text = displayMessage
         */
        model.message.observe(viewLifecycleOwner, Observer {
            displayM.text = it
        })

        return view
    }


}
