package com.example.myapplication.com.example.myapplication.webService.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.com.example.myapplication.webService.ConstantValue.Companion.BaseURL
import kotlinx.android.synthetic.main.activity_chap5_add_user.btnSave
import kotlinx.android.synthetic.main.activity_chap5_add_user.et_add_email
import kotlinx.android.synthetic.main.activity_chap5_add_user.et_add_job
import kotlinx.android.synthetic.main.activity_chap5_add_user.idTVResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chap5_add_user)
        postData(et_add_email.text.toString(), et_add_job.text.toString());

    }

    private fun postData(name: String, job: String) {
        btnSave.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("${BaseURL}api/") // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create()) // at last we are building our retrofit builder.
                .build()
            val retrofitAPI: ApiInterface = retrofit.create(ApiInterface::class.java)
            val modal = DataModal(name, job)

            retrofitAPI.createPost(modal)?.enqueue(object : Callback<PostResponse?> {

                override fun onResponse(
                    call: Call<PostResponse?>?,
                    response: Response<PostResponse?>?
                ) {
                    if (et_add_email.text?.isEmpty() == true) {
                        et_add_email.error = "enter name"
                        et_add_email.isFocusable

                    } else if (et_add_job.text?.isEmpty() == true) {
                        et_add_job.error = "enter job"
                        et_add_job.isFocusable
                    } else {
                        Toast.makeText(
                            this@AddUserActivity,
                            "Data added to API",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        response?.body()?.name = et_add_email.text.toString()
                        response?.body()?.job = et_add_job.text.toString()
                        val responseString = """
                         "Name: " ${response?.body()?.name}      
                          "Job: " ${response?.body()?.job}    
                          "created Date" ${response?.body()?.createdAt}   
                         """.trimIndent()
                        idTVResponse.text = responseString
                    }
                }

                override fun onFailure(call: Call<PostResponse?>?, t: Throwable?) {

                }
            })
        }
    }
}