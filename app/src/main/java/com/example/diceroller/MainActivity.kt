package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(R.id.imageView1)
            rollDice(R.id.imageView2)
        }

        rollDice(R.id.imageView1)
        rollDice(R.id.imageView2)
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(viewId: Int) {
        // Create dice object with 6 sides and roll the dice
        val dice: Dice = Dice(6)
        val diceRoll: Int = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(viewId)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResourceId: Int = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResourceId)

        // Update the ImageView content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}