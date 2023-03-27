package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFontPickerBinding
import com.example.myapplication.utils.Depo

class FontPickerFragment : Fragment() {
    private lateinit var binding: FragmentFontPickerBinding

    private val fonts = listOf(
        R.font.akaya_telivigala,
        R.font.germania_one,
        R.font.life_savers_bold,
        R.font.shadows_into_light
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFontPickerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val popup = PopupMenu(requireContext(), binding.FontTV)
        fonts.forEach { option ->
            popup.menu.add(option)
        }



        binding.FontTV.setOnClickListener {
            popup.setOnMenuItemClickListener { item ->
                when (item.title) {
                    "res/font/akaya_telivigala.ttf" -> {
                        Depo.obj.font = fonts[0]
                        binding.FontTV.typeface =
                            ResourcesCompat.getFont(requireContext(), Depo.obj.font)
                    }

                    "res/font/germania_one.ttf" -> {
                        Depo.obj.font = fonts[1]
                        binding.FontTV.typeface =
                            ResourcesCompat.getFont(requireContext(), Depo.obj.font)
                    }

                    "res/font/life_savers_bold" -> {
                        Depo.obj.font = fonts[2]
                        binding.FontTV.typeface =
                            ResourcesCompat.getFont(requireContext(), Depo.obj.font)
                    }

                    "res/font/shadows_into_light" -> {
                        Depo.obj.font = fonts[3]
                        binding.FontTV.typeface =
                            ResourcesCompat.getFont(requireContext(), Depo.obj.font)
                    }
                    else -> {}
                }
                true
            }
            popup.show()
        }

        binding.buttongoAge.setOnClickListener {
            Depo.obj.name = binding.enterNameET.text.toString()
            findNavController().navigate(FontPickerFragmentDirections.actionFontPickerFragmentToAgePickerFragment())
        }

    }




}