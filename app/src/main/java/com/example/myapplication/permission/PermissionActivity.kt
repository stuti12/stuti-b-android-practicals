package com.example.myapplication.permission

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.BuildConfig
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_permission.btnCamera
import kotlinx.android.synthetic.main.activity_permission.btnGallery
import kotlinx.android.synthetic.main.activity_permission.btnLocation
import kotlinx.android.synthetic.main.activity_permission.mImageView
import kotlinx.android.synthetic.main.activity_permission.pdfTextView


class PermissionActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        setCamera()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setCamera() {
        btnGallery.setOnClickListener {
            if (checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                imageChooser()
            } else {
                if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    showDialog("Need storage permission to Access pdf. Please provide permission to access your pdf.")
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        ),
                        Constants.TWO
                    )
                }
            }
        }

        btnCamera.setOnClickListener {
            if (checkPermission(Manifest.permission.CAMERA)) {
                 imagePicker()
            } else {
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    showDialog("Need storage permission to Access pdf. Please provide permission to access your pdf.")
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(
                            Manifest.permission.CAMERA
                        ),
                        Constants.ONE
                    )
                }

            }
        }

        btnLocation.setOnClickListener {
            if (checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                 selectPdf()
            } else {
                if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    showDialog("Need storage permission to Access pdf. Please provide permission to access your pdf.")
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        ),
                        Constants.THREE
                    )
                }
            }
        }
    }

    private fun showDialog(string: String) {
        AlertDialog.Builder(this)
            .setMessage(string)
            .setPositiveButton("OK") { dialogInterface, i ->
                dialogInterface.dismiss()
                //Open Settings
                startActivity(
                    Intent(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + BuildConfig.APPLICATION_ID)
                    )
                )
            }
            .setNegativeButton("Cancel") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            .create()
            .show()
    }

    fun imageChooser() {
        //Other Way for Open Image
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//        resultLauncher.launch(intent)
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        resultLauncher.launch(intent)
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.let {
                    val image = it.data
                    mImageView.setImageURI(image)
                }
            } else {
                Toast.makeText(this, "Picture not found", Toast.LENGTH_LONG).show()
            }
        }

    private fun imagePicker() {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        resultCameraLauncher.launch(intent)
    }

    private var resultCameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                val bitmap = intent?.extras?.get("data") as Bitmap
                mImageView.setImageBitmap(bitmap)
            } else {
                Toast.makeText(this, "Picture not found", Toast.LENGTH_LONG).show()
            }
        }

    private fun selectPdf() {
        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
        pdfIntent.type = Constants.pdf
        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
        resultPdfLauncher.launch(pdfIntent)
    }

    private var resultPdfLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.let {
                    val image = it.data
                    pdfTextView.text = image.toString()
                }
            } else {
                Toast.makeText(this, "Pdf not found", Toast.LENGTH_LONG).show()
            }
        }

    private fun checkPermission(vararg permission: String): Boolean = permission.all {
        ContextCompat.checkSelfPermission(
            this,
            it
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            when (requestCode) {
                Constants.ONE -> {
                    if (permissions[0] == Manifest.permission.CAMERA) {
                        imagePicker()
                    }
                }
                Constants.TWO -> {
                    if (permissions[0] == Manifest.permission.READ_EXTERNAL_STORAGE) {
                        imageChooser()
                    }
                }
                Constants.THREE -> {
                    if (permissions[0] == Manifest.permission.READ_EXTERNAL_STORAGE) {
                        selectPdf()
                    }
                }
            }

        }
    }
}