package com.example.firestore

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.firestore.databinding.FragmentMailConfirmBinding
import com.google.firebase.auth.FirebaseAuth


class MailConfirmFragment : Fragment() {
    private  lateinit var binding: FragmentMailConfirmBinding
    private lateinit var  mAuth: FirebaseAuth
    private  lateinit var  userEmail: String
    private  lateinit var   enterEmail : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMailConfirmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.buttonConfirm.setOnClickListener {
            userEmail = mAuth.currentUser?.email.toString()
            enterEmail = binding.MailConfirmET.text.toString().trim().lowercase()
            emailConfirmation(userEmail,enterEmail)
        }
    }

    private fun emailConfirmation(userEmail:String,enterEmail:String) {
        if (userEmail == enterEmail) {
            binding.textView.apply {
                mAuth.currentUser?.sendEmailVerification()
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Verification email sent successfully
                            setBackgroundColor(Color.GREEN)
                            findNavController().navigate(
                                MailConfirmFragmentDirections.actionMailConfirmFragmentToLoginFragment()
                            )
                        } else {
                            Toast.makeText(requireContext(), "Giriş gg", Toast.LENGTH_SHORT).show()
                        }

                    }
            }
        } else {
            binding.textView.apply {
                setBackgroundColor(Color.RED)
            }
        }
    }


}


/*
private fun emailConfirmation(userEmail:String,enterEmail:String){
        val actionCodeSettings = actionCodeSettings {
            // URL you want to redirect back to. The domain (www.example.com) for this
            // URL must be whitelisted in the Firebase Console.
            url = "https://www.example.com/finishSignUp?cartId=1234"
            // This must be true
            handleCodeInApp = true
            setAndroidPackageName(
                "com.example.android",
                true, /* installIfNotAvailable */
                "12" /* minimumVersion */)
        }

        if (userEmail==enterEmail){
            binding.textView.apply {
                mAuth.sendSignInLinkToEmail(userEmail, actionCodeSettings)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "Email sent.")
                        }
                    }
                setBackgroundColor(Color.GREEN)
                findNavController().navigate(
                    MailConfirmFragmentDirections.actionMailConfirmFragmentToLoginFragment())
            }
        }
        else{
            binding.textView.apply {
                setBackgroundColor(Color.RED)
            }
        }
    }
 */