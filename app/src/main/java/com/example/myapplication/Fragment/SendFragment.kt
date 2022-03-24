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

class SendFragment : Fragment() {
    private val args: SendFragmentArgs by navArgs<SendFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.btn_send_message_jetpack)
        val ettext: EditText = view.findViewById(R.id.et_msg_title)
        val tv1: TextView = view.findViewById(R.id.tv_show)

        val name: String = args.nam
        tv1.text = name

        button.setOnClickListener {
            val action =
                SendFragmentDirections.actionSendFragmentToViewFragment(ettext.text.toString())
            // val action = SendFragmentDirections.actionSendFragmentToViewFragment(ettext.text.toString())
            Toast.makeText(requireContext(), "hello", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(action)
        }
    }
}