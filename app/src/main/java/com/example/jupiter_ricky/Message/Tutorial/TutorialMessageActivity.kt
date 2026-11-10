
package com.example.jupiter_ricky.Message.Tutorial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jupiter_ricky.R
import com.example.jupiter_ricky.databinding.ActivityTutorialMessageBinding

class TutorialMessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTutorialMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
        val fragmentsList = listOf(Tutorial1Fragment(), Tutorial2Fragment(), Tutorial3Fragment())
        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        binding.tutorialMessageViewPager.adapter = adapter
        binding.dotIndicator.attachTo(binding.tutorialMessageViewPager)
    }
}
