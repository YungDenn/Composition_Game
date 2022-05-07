package com.example.compositiongame.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.compositiongame.R
import com.example.compositiongame.domain.entity.GameResult


interface OnOptionClickListener {
    fun onOptionClick(option: Int)
}
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

@BindingAdapter("enoughCount")
fun bindEnoughCount(textView: TextView, enough: Boolean) {
    textView.setTextColor(getColorByState(textView.context, enough))
}

@BindingAdapter("enoughPercent")
fun bindEnoughPercent(progressBar: ProgressBar, enough: Boolean) {
    val color = getColorByState(progressBar.context, enough)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

private fun getColorByState(context: Context, goodState: Boolean): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("numberAsText")
fun bindNumberAsText(textView: TextView, number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, clickListener: OnOptionClickListener) {
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}
