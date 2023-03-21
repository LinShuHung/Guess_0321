package com.suhun.guess0321

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.suhun.guess0321.databinding.ActivityRecordBinding

class RecordActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRecordBinding
    var tag = RecordActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val count:Int = intent.getIntExtra("COUNT", -1)
        binding.countScort.text = count.toString()
        binding.saveButton.setOnClickListener {view->
            var playerName:String = binding.nameEditText.text.toString()
            var recordResult:String? = getSharedPreferences("record_guess", MODE_PRIVATE)
                .getString("RESULT", "null")
            var writeString:String
            if(recordResult.equals("null")){
                writeString = "$playerName /t $count"

            }else{
                writeString = "$recordResult /n $playerName /t $count /n"
            }
            getSharedPreferences("record_guess", MODE_PRIVATE)
                .edit().putString("RESULT", writeString)
                .commit()
            Log.d(tag, "Result is $writeString")
            var intent:Intent = Intent(this, ShowScoreActivity::class.java)
            intent.putExtra("SHOW", writeString)
            startActivity(intent)
        }

//        var recordResult = getSharedPreferences("record_guess", MODE_PRIVATE)
//            .getString("RESULT", "null")
//        if(recordResult.equals("null")){
//
//        }
    }
}