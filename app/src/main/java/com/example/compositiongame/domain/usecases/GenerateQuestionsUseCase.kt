package com.example.compositiongame.domain.usecases

import com.example.compositiongame.domain.entity.Question
import com.example.compositiongame.domain.repository.GameRepository

class GenerateQuestionsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTION)
    }

    private companion object {

        private const val COUNT_OF_OPTION = 6

    }
}