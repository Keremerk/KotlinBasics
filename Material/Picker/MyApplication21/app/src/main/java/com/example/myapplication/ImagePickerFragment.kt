package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentImagePickerBinding
import com.example.myapplication.utils.Depo


class ImagePickerFragment : Fragment() {

    private lateinit var binding: FragmentImagePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImagePickerBinding.inflate(inflater, container, false)
        val view = binding.root

        imagePicker()

        binding.buttonFont.setOnClickListener {
            findNavController().navigate(ImagePickerFragmentDirections.actionImagePickerFragmentToFontPickerFragment())
        }
        return view
    }

    private fun imagePicker() {
        // Registers a photo picker activity launcher in single-select mode.
        val pickMedia =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                if (uri != null) {
                    Depo.obj.image = uri.toString()
                    println(uri.toString())
                    val imageUri = Uri.parse(uri.toString())
                    binding.imageView.setImageURI(imageUri)
                }
            }
        // Launch the photo picker and allow the user to choose only images.
        binding.imageView.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        // Launch the photo picker and allow the user to choose only images/videos of a
        // specific MIME type, such as GIFs.
        val mimeType = "image/png"
        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.SingleMimeType(mimeType)))
    }


}