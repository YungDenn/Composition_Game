 package com.example.compositiongame.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.compositiongame.R
import com.example.compositiongame.databinding.ActivityMainBinding
import com.example.compositiongame.databinding.FragmentGameFinishedBinding
import java.lang.RuntimeException

 class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
     }


}