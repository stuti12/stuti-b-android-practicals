package com.example.myapplication.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSendMessageBinding
import kotlinx.android.synthetic.main.fragment_send_message.btn_send_message

class SendMessageFragment : Fragment() {

   // private lateinit var communicator: Communicator
    private lateinit var binding: FragmentSendMessageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_send_message, container, false)
        //other way for data passing
        /*communicator = activity as Communicator*/
        val button:Button = view.findViewById(R.id.btn_send_message)
        val textMessage:EditText = view.findViewById(R.id.et_msg_title)
        val model = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        button.setOnClickListener {
            //communicator.passData(textMessage.text.toString())
            model.sendMessage(textMessage.text.toString())
            textMessage.text = null
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}
