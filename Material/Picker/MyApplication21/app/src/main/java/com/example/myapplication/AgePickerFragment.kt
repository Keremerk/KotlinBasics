package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentAgePickerBinding
import com.example.myapplication.utils.Depo
import java.util.*
import java.util.concurrent.TimeUnit


class AgePickerFragment : Fragment() {
    private lateinit var binding: FragmentAgePickerBinding
    private val calendar = Calendar.getInstance()
    private val year = calendar.get(Calendar.YEAR)
    private val month = calendar.get(Calendar.MONTH)
    private val day = calendar.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgePickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonGoMain.setOnClickListener {
            findNavController().navigate(AgePickerFragmentDirections.actionAgePickerFragmentToZeroFragment())

        }

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(selectedYear, selectedMonth, selectedDay)

                val ageInMillis = System.currentTimeMillis() - selectedDate.timeInMillis
                val ageInYears = TimeUnit.MILLISECONDS.toDays(ageInMillis) / 365
                Depo.obj.age = ageInYears.toString()
                print(Depo.obj.age)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()


    }

}



