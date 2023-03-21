package com.suhun.guess0321

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.suhun.guess0321.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var tag = MainActivity::class.java.simpleName
    var secretNumber:SecretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("Reset Game")
                .setMessage("Are you sure?").setPositiveButton("Ok", {dialog, which->
                    secretNumber.resetAll()
                    binding.contentLayout.userInputEditText.text = null
                    binding.contentLayout.counterText.hint = "0"
                    binding.contentLayout.counterText.text = "0"
                })
                .show()
        }
        binding.contentLayout.GuessButton.setOnClickListener {view->
            var userInupt:Int = binding.contentLayout.userInputEditText.text.toString().toInt()
            var message:String = secretNumber.verifyResult(resources, userInupt)
            var bingo = if(secretNumber.verify(userInupt)==0) true else false
            binding.contentLayout.counterText.text = "${secretNumber.guessCount.toString()} times"
            AlertDialog.Builder(this)
                .setTitle("Guess Result")
                .setMessage(message)
                .setPositiveButton("ok", {dialog, which->
                    binding.contentLayout.userInputEditText.text = null
                    if(bingo){
                        val intent:Intent = Intent(this, RecordActivity::class.java)
                        intent.putExtra("COUNT", secretNumber.guessCount)
                        startActivity(intent)
                    }
                })
                .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}