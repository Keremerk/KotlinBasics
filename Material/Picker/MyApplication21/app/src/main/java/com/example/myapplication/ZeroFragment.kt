package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentZeroBinding
import com.example.myapplication.utils.Depo


class ZeroFragment : Fragment() {
    private lateinit var binding: FragmentZeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentZeroBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            nameTv3.text = Depo.obj.name
            ageTv3.text = Depo.obj.age.toString()
            nameTv3.typeface = ResourcesCompat.getFont(requireContext(),Depo.obj.font)
            ageTv3.typeface = ResourcesCompat.getFont(requireContext(),Depo.obj.font)
            val imageUri = Uri.parse(Depo.obj.image)
            imageView3.setImageURI(imageUri)
        }


        binding.buttonZero.setOnClickListener {
            findNavController().navigate(ZeroFragmentDirections.actionZeroFragmentToImagePickerFragment())
        }
    }
}