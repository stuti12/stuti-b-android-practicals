package com.example.myapplication.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R


class ViewFragment : Fragment() {
    private val args: ViewFragmentArgs by navArgs<ViewFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view, container, false)
        val tv1: TextView = view.findViewById(R.id.tv_show)

        val name: String = args.name
        tv1.text = name

        val btn: Button = view.findViewById(R.id.btn_send_message2)
        val et1: EditText = view.findViewById(R.id.et_msg_title2)
        btn.setOnClickListener {
            val action =
                ViewFragmentDirections.actionViewFragmentToSendFragment(et1.text.toString())
            Toast.makeText(requireContext(), "hello", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(action)
        }
        return view
    }
}