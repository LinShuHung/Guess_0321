package com.suhun.guess0321

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suhun.guess0321.databinding.ActivityRecordBinding

class RecordActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRecordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}