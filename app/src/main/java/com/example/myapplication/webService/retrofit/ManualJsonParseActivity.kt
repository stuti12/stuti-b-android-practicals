package com.example.myapplication.webService.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.com.example.myapplication.webService.ConstantValue.Companion.BaseURL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_ch5_manual_json_parse.button
import kotlinx.android.synthetic.main.activity_ch5_manual_json_parse.imgAvtar
import kotlinx.android.synthetic.main.activity_ch5_manual_json_parse.txtData
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import java.net.URL


class ManualJsonParseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ch5_manual_json_parse)
        button.setOnClickListener {
            Thread {
                getManualData()
            }.start()
        }

    }
    private fun getManualData() {
        val client = OkHttpClient()
        val url = URL("{$BaseURL}api/users/2")
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread{
                    val text = "Not Able to Fetch User Data"
                    txtData.text = text
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val responseStatus = response.body!!.string()
                val data = JSONObject(responseStatus).getJSONObject("data")
                val text = "Name: ${data.get("first_name")}  ${data.get("last_name")}\nEmail: ${data.get("email")}"
                val img = "${data.get("avatar")}"
                runOnUiThread {
                    txtData.text = text
                    Picasso.get().load(img).into(imgAvtar)
                }
            }
        })
    }

}