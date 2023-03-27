package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment() {
    private  lateinit var binding: FragmentRegisterBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()


        binding.textViewClick.setOnClickListener {
            findNavController().navigate(
                RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }

        binding.buttonRegister.setOnClickListener {
            val email = binding.EmailAddressET.text.toString().trim().lowercase()
            val pass = binding.SignUpPasswordET.text.toString().trim().lowercase()
            if (email.isNotEmpty() && pass.isNotEmpty()) {
                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            findNavController().navigate(
                                RegisterFragmentDirections.actionRegisterFragmentToMailConfirmFragment())
                            Toast.makeText(requireContext(), "Giriş Başarılı", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(requireContext(), "Giriş Hatalı", Toast.LENGTH_SHORT).show()

                        }
                    }

                } else {
                Toast.makeText(requireContext(), "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}





