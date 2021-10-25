package com.example.kotlin_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        btn_mora.setOnClickListener(View.OnClickListener
        {
            //判断字串是否是空白来要求输入姓名
            if (ed_name.length() < 1) {
                tv_text.text = "請輸入玩家姓名"
                tv_name.text ="名字"
            }
            else {
                //顯示玩家姓名與我方出拳
                tv_name.text = String.format("名字\n%s", ed_name.text)

               /* if (btn_scissor.isChecked)
                    tv_mmora.text = "我方出拳\n剪刀"
                else if (btn_stone.isChecked)
                    tv_mmora.text = "我方出拳\n石頭"
                else
                    tv_mmora.text = "我方出拳\n布"
                */
                val playerMoraText = when {
                    btn_scissor.isChecked->"剪刀"
                    btn_stone.isChecked->"石頭"
                    else ->"布"
                }
                tv_mmora.text="名字\n$playerMoraText"
                //Random()
                val computer = (Math.random() * 3).toInt()
                /*if (computer == 0) tv_cmora.text = "電腦出拳\n剪刀"
                else if (computer == 1) tv_cmora.text = "電腦出拳\n石頭"
                else tv_cmora.text = "電腦出拳\n布"
                */
                tv_cmora.text=when{
                    computer==0->"電腦出拳\n剪刀"
                    computer==1->"電腦出拳\n石頭"
                    else->"電腦出拳\n布"
                }

                //val playername=ed_name.text
                //判斷輸贏
                if (btn_scissor.isChecked && computer == 2 || btn_stone.isChecked && computer == 0 || btn_paper.isChecked && computer == 1) {
                    tv_winner.text = "勝利者\n"+"${ed_name.text}"
                    tv_text.text = "恭喜你獲勝了！！！"
                }
                else if (btn_scissor.isChecked && computer == 1 || btn_stone.isChecked && computer == 2 || btn_paper.isChecked && computer == 0) {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "可惜，電腦獲勝了！"
                }
                else {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平局，請再試一次"
                }
            }
        })
    }
}