package com.example.compositiongame.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.compositiongame.R
import com.example.compositiongame.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}
@BindingAdapter("requiredCountAnswers")
fun bindRequiredCountAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        count
    )
}
@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, count: Int) {
        textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        count
    )
}
@BindingAdapter("requiredTotalPercentage")
fun bindRequiredTotalPercentage(textView: TextView, result: GameResult) {
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(result)
    )
}
private fun getPercentOfRightAnswers(result: GameResult): Int{
    return if (result.countOfQuestions == 0){
        0
    }else {
        ((result.countOfRightAnswers/result.countOfQuestions.toDouble())*100).toInt()
    }
}

@BindingAdapter("requiredEmoji")
fun bindEmoji(imageView: ImageView, result: GameResult){
    imageView.setImageResource(getEmoji(result))
}
private fun getEmoji(result: GameResult):Int{
    return if (result.winner){
        R.drawable.ic_smile
    }
    else{
        R.drawable.ic_sad
    }
}
