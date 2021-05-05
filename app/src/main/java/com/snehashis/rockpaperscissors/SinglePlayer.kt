package com.snehashis.rockpaperscissors

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_single_player.*
import kotlin.random.Random

var score = 0
@SuppressLint("SetTextI18n")
class SinglePlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_player)
        rocksBt.setOnClickListener {
            updateStatus(playGame(0))
        }
        paperBt.setOnClickListener {
            updateStatus(playGame(1))
        }
        scissorBt.setOnClickListener {
            updateStatus(playGame(2))
        }
    }

    private fun playGame(playerMove : Int) : Int {
        val botMove = Random.nextInt(3)
        val botString = if (botMove == 0) "Rock" else if (botMove == 1) "Paper" else "Scissors"
        val playerString = if (playerMove == 0) "Rock" else if (playerMove == 1) "Paper" else "Scissors"
        moves.text = "BOT: $botString\nPlayer: $playerString"
        //0->Rock
        //1->Paper
        //2->Scissor
        return if (playerMove == botMove)
            -1
        else if (playerMove - botMove == 1 || playerMove - botMove == -2)
            1
        else
            0
    }

    private fun updateStatus(result : Int) {
        when (result) {
            0 -> {
                gameResult.text = "You Loose"
                score -= 30
            }
            1 -> {
                gameResult.text = "You Win!!!"
                score += 100
            }
            else -> {
                gameResult.text = "Tie"
                score += 5
            }
        }
        gameScore.text = "Score: $score"
    }
}