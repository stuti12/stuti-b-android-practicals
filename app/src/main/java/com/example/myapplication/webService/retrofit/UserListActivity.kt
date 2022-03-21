package com.example.myapplication.com.example.myapplication.webService.retrofit

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.example.myapplication.R
import com.example.myapplication.com.example.myapplication.webService.ConstantValue.Companion.BaseURL
import com.example.myapplication.com.example.myapplication.webService.ReqRes

import kotlinx.android.synthetic.main.chap4_activity_user_list.btnAdd
import kotlinx.android.synthetic.main.chap4_activity_user_list.recycleUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserListActivity : AppCompatActivity() {
    private val dataList: MutableList<ReqRes> = mutableListOf()
    private lateinit var myAdapter: UserDataAdapter
    private lateinit var userInstance: ApiInterface
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chap4_activity_user_list)
        dialog = Dialog(this)
        showDialog()
        //  setAdapter()
        getUserData()
        setListener()
    }
    private fun showDialog() {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.chap4_custom_dialog)
        dialog.show()
    }
    private fun setListener() {
        btnAdd.setOnClickListener {
            val intent = Intent(this@UserListActivity, AddUserActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getUserData() {
        val retrofit = Retrofit.Builder().baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        userInstance = retrofit.create(ApiInterface::class.java)
        var user = userInstance.allUserApi()
        user.enqueue(object : Callback<ReqRes> {

            override fun onResponse(
                call: Call<ReqRes>?,
                response: Response<ReqRes>?
            ) {
                val user: ReqRes? = response!!.body()
                if (user != null) {
                    myAdapter = UserDataAdapter(user.data)
                    recycleUser.layoutManager = LinearLayoutManager(this@UserListActivity)
                    recycleUser.addItemDecoration(
                        DividerItemDecoration(
                            this@UserListActivity,
                            OrientationHelper.VERTICAL
                        )
                    )
                    recycleUser.adapter = myAdapter
                    dialog.dismiss()
                }

            }

            override fun onFailure(call: Call<ReqRes>?, t: Throwable?) {
                Log.d("Data", "Error")
            }
        })
    }
}