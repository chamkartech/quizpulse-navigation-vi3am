package com.example.quizpulse_navigation.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quizpulse_navigation.databinding.FragmentQuizFailedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizFailedFragment : Fragment() {

    private var _binding: FragmentQuizFailedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizFailedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTryAgain.setOnClickListener {
            findNavController().navigate(
                QuizFailedFragmentDirections.actionQuizFailedFragmentToHomeFragment()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
