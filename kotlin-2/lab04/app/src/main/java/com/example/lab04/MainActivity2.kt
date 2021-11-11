package com.example.lab04

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn_send = findViewById<Button>(R.id.btn_send)
        val ed_drink = findViewById<EditText>(R.id.drink)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup1)


        btn_send.setOnClickListener{
            if(ed_drink.length() < 1) Toast.makeText(this,"請輸入飲料名稱", Toast.LENGTH_SHORT).show()
            else {
                val b = Bundle()
                b.putString("drink",ed_drink.text.toString())
                b.putString("sugar",radioGroup.findViewById<RadioButton>
                    (radioGroup.checkedRadioButtonId).text.toString())
                b.putString("ice", radioGroup1.findViewById<RadioButton>
                    (radioGroup1.checkedRadioButtonId).text.toString())
                setResult(AppCompatActivity.RESULT_OK, Intent().putExtras(b))
                finish()
            }
        }
    }
}