package com.example.quizpulse_navigation.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizpulse_navigation.databinding.FragmentQuizWonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizWonFragment : Fragment() {

    private var _binding: FragmentQuizWonBinding? = null
    private val binding get() = _binding!!

    private val args: QuizWonFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizWonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvScore.text = "${args.score} / ${args.total}"

        binding.btnPlayAgain.setOnClickListener {
            findNavController().navigate(
                QuizWonFragmentDirections.actionQuizWonFragmentToHomeFragment()
            )
        }

        binding.btnShare.setOnClickListener {
            // Share result logic
            val shareIntent = android.content.Intent(android.content.Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(
                    android.content.Intent.EXTRA_TEXT,
                    "I scored ${args.score} / ${args.total} on QuizPulse! Can you beat me?"
                )
            }
            startActivity(android.content.Intent.createChooser(shareIntent, "Share your score"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
