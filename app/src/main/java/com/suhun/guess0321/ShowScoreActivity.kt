package com.suhun.guess0321

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suhun.guess0321.databinding.ActivityShowScoreBinding

class ShowScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityShowScoreBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val result:String? = intent.getStringExtra("SHOW")
        binding.resultTextView.text = result
        binding.backButton.setOnClickListener {view->
            val intent:Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}