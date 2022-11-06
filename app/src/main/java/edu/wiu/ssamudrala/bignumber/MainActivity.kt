package edu.wiu.ssamudrala.bignumber

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_lft: Button = findViewById(R.id.buttonlft)
        val button_rgt: Button = findViewById(R.id.buttonrgt)

        button_lft.setOnClickListener {

            checkAnswer(true)
            assignNumbersToButtons()
        }

        button_rgt.setOnClickListener {

            checkAnswer(false)
            assignNumbersToButtons()
        }

    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {

        val button_lft: Button = findViewById(R.id.buttonlft)
        val button_rgt: Button = findViewById(R.id.buttonrgt)
        val button_bg: Button = findViewById(R.id.buttonbg)

        val lftnum = button_lft.text.toString().toInt()
        val rgtnum = button_rgt.text.toString().toInt()

        val isAnswerCorrect = if(isLeftButtonSelected) lftnum > rgtnum else lftnum < rgtnum

        if(isAnswerCorrect){
            //change color to green
            //toast
            button_bg.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()

        }else{
            button_bg.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {

        val button_lft: Button = findViewById(R.id.buttonlft)
        val button_rgt: Button = findViewById(R.id.buttonrgt)

        val r = Random()
        val lftnum = r.nextInt(10)
        var rgtnum = lftnum
        while(rgtnum == lftnum){
            rgtnum = r.nextInt(10)
        }
        button_lft.text = lftnum.toString()
        button_rgt.text = rgtnum.toString()

    }
}