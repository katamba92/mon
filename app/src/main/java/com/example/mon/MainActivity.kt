package com.example.mon

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton= findViewById<Button>(R.id.Roll)
        rollButton.setOnClickListener { rollDice() }
        // do the dice when the app starts
        rollDice()
    }

    private fun rollDice() {
        // create new dice objects with 6 sides and rool it
        val dice = Dice(6)
        val diceRoll =dice.roll()
        //find the imageview in the layout
        val diceimage = findViewById<ImageView>(R.id.ivdevice)
        //Determine which drawable Resource id to use based on the dice roll used
        val drawableResource=when (diceRoll){
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        //update image view with the correct drawable resource id
        diceimage.setImageResource(drawableResource)

        diceimage.contentDescription=diceRoll.toString()
    }


}
