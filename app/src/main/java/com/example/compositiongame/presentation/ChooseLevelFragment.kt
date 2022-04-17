package com.example.compositiongame.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.compositiongame.R
import com.example.compositiongame.databinding.FragmentChooseLevelBinding
import com.example.compositiongame.databinding.FragmentWelcomeBinding
import com.example.compositiongame.domain.entity.Level
import java.lang.RuntimeException

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            buttonLevelTest.setOnClickListener{
                launchGame(Level.TEST)
            }
            buttonLevelEasy.setOnClickListener{
                launchGame(Level.EASY)
            }
            buttonLevelNormal.setOnClickListener{
                launchGame(Level.NORMAL)
            }
            buttonLevelHard.setOnClickListener{
                launchGame(Level.HARD)
            }
        }
    }

    private fun launchGame(level: Level){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFragment.newInstance(level))
            .addToBackStack(GameFragment.NAME)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object{

        const val NAME = "ChooseLevelFragment"

        fun newInstance(): ChooseLevelFragment{
            return ChooseLevelFragment()
        }
    }

}