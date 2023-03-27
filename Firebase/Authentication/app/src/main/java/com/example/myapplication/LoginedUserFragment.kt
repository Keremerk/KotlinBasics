package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLoginedUserBinding
import com.google.firebase.auth.FirebaseAuth


class LoginedUserFragment : Fragment() {

    private  lateinit var binding: FragmentLoginedUserBinding
    private lateinit var  mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginedUserBinding.inflate(inflater, container, false)

        binding.buttonLogout.setOnClickListener {
            mAuth.signOut()

            Toast.makeText(requireContext(), "Logout Successful !", Toast.LENGTH_SHORT).show()
            findNavController().navigate(
                LoginedUserFragmentDirections.actionLoginedUserFragmentToRegisterFragment())
        }


        return binding.root
    }


}