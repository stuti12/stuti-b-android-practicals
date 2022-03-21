package com.example.myapplication.com.example.myapplication.webService.retrofit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.com.example.myapplication.webService.Data
import com.example.myapplication.com.example.myapplication.webService.UserID
import com.example.myapplication.webService.retrofit.SingleUserActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.chap4_user_details_item.view.cellLayour
import kotlinx.android.synthetic.main.chap4_user_details_item.view.lblEmail
import kotlinx.android.synthetic.main.chap4_user_details_item.view.lbluserName
import kotlinx.android.synthetic.main.chap4_user_details_item.view.userAvtar

class UserDataAdapter(
    private val elements: List<Data>
) : RecyclerView.Adapter<UserDataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chap4_user_details_item, parent, false)
        return UserDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        val element: Data = elements[position]
        holder.userName.text = "${element.firstName} ${element.lastName}"
        holder.userEmail.text = element.email
        Picasso.get().load(element.avatar).into(holder.userAvatar)
        holder.layout.setOnClickListener {
            val intent = Intent(holder.itemView.context, SingleUserActivity::class.java)
            intent.putExtra(UserID, element.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return elements.size
    }

}

class UserDataViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var userName = view.lbluserName
    var userEmail = view.lblEmail
    var userAvatar = view.userAvtar
    var layout = view.cellLayour

    init {
        layout.setOnClickListener {
            val intent = Intent(view.context, SingleUserActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}

