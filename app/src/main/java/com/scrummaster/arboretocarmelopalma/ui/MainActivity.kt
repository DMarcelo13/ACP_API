package com.scrummaster.arboretocarmelopalma.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scrummaster.arboretocarmelopalma.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}