package com.suhun.guess0321

import android.content.res.Resources
import android.util.Log
import java.util.Random

class SecretNumber {
    val tag = SecretNumber::class.java.simpleName
    var guessRandom:Int
    var guessCount:Int = 0
    init{
        guessRandom = Random().nextInt(100) + 1
        Log.d(tag, "Secret number is $guessRandom")
    }

    fun verify(userInput:Int) = guessRandom - userInput

    fun verifyResult(r:Resources, userInput: Int):String{
        guessCount++
        if(verify(userInput)>0){
            return "Bigger!!!"
        }else if(verify(userInput)<0){
            return "Smaller!!!"
        }else{
            if(guessCount<3){
                return "Excellent! The number is $guessRandom!!!"
            }else{
                return "You got it!!!"
            }
        }
    }

    fun resetAll(){
        guessCount = 0
        guessRandom = Random().nextInt(100) + 1
        Log.d(tag, "Reset secret number is $guessRandom")
    }
}