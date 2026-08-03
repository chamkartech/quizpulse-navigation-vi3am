package com.example.quizpulse_navigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quizpulse_navigation.R
import com.example.quizpulse_navigation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartQuiz.setOnClickListener {
            val categoryName = when (binding.rgCategory.checkedRadioButtonId) {
                R.id.rbAndroid -> "Android"
                R.id.rbKotlin -> "Kotlin"
                R.id.rbGeneral -> "General"
                else -> "Android"
            }

            val action = HomeFragmentDirections
                .actionHomeFragmentToQuizFragment(categoryName = categoryName)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
