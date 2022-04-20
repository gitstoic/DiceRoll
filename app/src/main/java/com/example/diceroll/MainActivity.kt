package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btn_roll)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
//        Create new dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val image1: ImageView = findViewById(R.id.diceImage1)
        val image2: ImageView = findViewById(R.id.diceImage2)
        val image3: ImageView = findViewById(R.id.diceImage3)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image1.setImageResource(drawableResource)

        val dice2 = Dice(6)
        val drawableResource2 = when (dice2.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image2.setImageResource(drawableResource2)

        val dice3 = Dice(6)
        val drawableResource3 = when (dice3.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image3.setImageResource(drawableResource3)

        //creates toast message that shows “You Win” when at least 2 dice throw a 6 each
        if (diceRoll == 6 && dice2.roll() == 6 ||
            diceRoll == 6 && dice3.roll() == 6 ||
            dice2.roll() == 6 && dice3.roll() == 6
        ) {
            Toast.makeText(this, "You Win", Toast.LENGTH_SHORT).show()

            //creates toast message that shows “You lose” when at least 2 dice throw a total sum of 9
        } else if (diceRoll + dice2.roll() == 9 ||
            diceRoll + dice3.roll() == 9 ||
            dice2.roll() + dice3.roll() == 9||
            diceRoll + dice2.roll() + dice3.roll() == 9

        ) {
            Toast.makeText(this, "You Lose", Toast.LENGTH_SHORT).show()
        }
    }

    class Dice(private val sides: Int) {

        fun roll(): Int {
            return (1..sides).random()
        }
    }
}
