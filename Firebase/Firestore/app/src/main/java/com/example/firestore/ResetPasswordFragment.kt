package com.example.firestore

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.firestore.databinding.FragmentResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth


class ResetPasswordFragment : Fragment() {

    private  lateinit var binding: FragmentResetPasswordBinding
    private lateinit var  mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResetPasswordBinding.inflate(inflater, container, false)



        binding.button2.setOnClickListener {
            val emailAddress = binding.EmailET.text.toString().trim().lowercase()
            if (emailAddress.isEmpty()) {
                Toast.makeText(requireContext(),"Emailinizi girmediniz", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "Email sent.")
                            findNavController().navigateUp()
                        }
                    }

            }
        }


        return binding.root
    }





}