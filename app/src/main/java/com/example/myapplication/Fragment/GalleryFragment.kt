package com.example.myapplication.Fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_gallery.IVPreviewImage
import kotlinx.android.synthetic.main.fragment_gallery.floatingActionButton

class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floatingActionButton.setOnClickListener {

          imageChooser()
        }
    }

    private fun imageChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        resultLauncher.launch(intent)
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            val selectedImageUri: Uri? = data?.data
            if (null != selectedImageUri) {
                // update the preview image in the layout
                IVPreviewImage.setImageURI(selectedImageUri)
            }
        }
    }
}