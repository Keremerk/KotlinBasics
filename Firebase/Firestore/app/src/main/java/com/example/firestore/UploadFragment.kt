package com.example.firestore

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.firestore.databinding.FragmentUploadBinding
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.*

class UploadFragment : Fragment() {
    private lateinit var binding: FragmentUploadBinding
    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore
    private val storage = Firebase.storage
    var selectedPostImage: Uri? = null
    var selectedBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUploadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth

        binding.apply {
            buttonSelect.setOnClickListener {
                println("tıklandı")
                selectedImage()
            }
            buttonUpload.setOnClickListener {
                shareImage()
                findNavController().navigateUp()
            }
        }
    }

    private fun shareImage() {
        if (selectedPostImage != null) {
            val reference = storage.reference
            val uuid = UUID.randomUUID()
            var imageName = "${uuid}.jpg"

            val imageReference = reference.child("Image").child(imageName)

            imageReference.putFile(selectedPostImage!!).addOnSuccessListener { task ->
                //URL alıncak
                val yuklenenGorselReferansi = reference.child("Image").child(imageName)
                yuklenenGorselReferansi.downloadUrl.addOnSuccessListener { uri ->
                    val downloadUrl = uri.toString()
                    val userId = auth.currentUser?.uid
                    val userEmail = auth.currentUser?.email
                    val dateNow = Timestamp.now()

                    val postMap = hashMapOf<String, Any>()

                    postMap.put("userId", userId!!)
                    postMap.put("userEmail", userEmail!!)
                    postMap.put("dateNow", dateNow)
                    postMap.put("imageUrl", downloadUrl)

                    db.collection("Post").add(postMap).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(requireContext(), "Succesfull...", Toast.LENGTH_LONG)
                                .show()
                        }

                    }.addOnFailureListener { exception ->
                        Toast.makeText(
                            requireContext(),
                            exception.localizedMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }

            }
        }
    }

    fun selectedImage() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // İZİN VERİLMEMİŞ,İZİN İSTİYORUZ
            ActivityCompat.requestPermissions(
                requireContext() as Activity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        } else {
            //İZİN VERİLMİŞ GALERİYE GİDİYORUZ
            val galeriIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galeriIntent, 2)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //izin verilmiş
                val galeriIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntent, 2)
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 2 && resultCode == AppCompatActivity.RESULT_OK && data != null) {
            selectedPostImage = data.data
            binding.imageView.visibility = View.VISIBLE
            if (selectedPostImage != null) {

                if (Build.VERSION.SDK_INT >= 28) {

                    val source = ImageDecoder.createSource(
                        requireContext().contentResolver,
                        selectedPostImage!!
                    )
                    selectedBitmap = ImageDecoder.decodeBitmap(source)
                    binding.imageView.setImageBitmap(selectedBitmap)
                } else {
                    selectedBitmap = MediaStore.Images.Media.getBitmap(
                        requireContext().contentResolver,
                        selectedPostImage
                    )
                    binding.imageView.setImageBitmap(selectedBitmap)
                }
            }

        }
        super.onActivityResult(requestCode, resultCode, data)
    }



}










//private fun uploadPhoto(imageUri: Uri?) {
//    if (imageUri == null) return
//    val filename = UUID.randomUUID().toString()
//    val storageRef = Firebase.storage.reference
//    val photoRef = storageRef.child("photos/$filename")
//
//    // Upload the photo file to Firebase Storage
//    photoRef.putFile(imageUri)
//        .addOnSuccessListener {
//            // If the upload is successful, get the download URL for the photo
//            photoRef.downloadUrl.addOnSuccessListener { downloadUrl ->
//                setFragmentResult(
//                    Keys.REQUEST_KEY,
//                    bundleOf(Keys.BUNDLE_KEY to downloadUrl.toString())
//                )
//
//
//                findNavController().navigateUp()
//            }
//        }
//        .addOnFailureListener { exception ->
//            Log.e(ContentValues.TAG, "Error uploading photo", exception)
//            // Handle the error
//        }
//}