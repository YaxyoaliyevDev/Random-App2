package com.example.randomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.randomapp.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity(), MyServiceInterface {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var count = 0
    var randomSon = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        randomNumber()
        binding.btnConfirm.setOnClickListener {
            checking()
        }


    }

    override fun randomNumber() {
        randomSon = Random().nextInt(100)
        binding.tvBetween.text = "0 va 100 oralig'ida son yozing.."

    }

    override fun counting() {
        count++

    }

    override fun checking() {
        counting()
        val n = binding.edtNumber.text.toString().toInt()
        if (n == randomSon) {
            Toast.makeText(this, "Siz $count urunishda topdingiz", Toast.LENGTH_SHORT).show()
            binding.tvBetween.text = "Siz $count urunishda topdingiz"

        } else if (n<randomSon) {
            Toast.makeText(this, "Ozgina qo'shing", Toast.LENGTH_SHORT).show()
            binding.tvInfo.text ="Siz yozgan son biz o'ylangan sondan kichik "
        }else if (n>randomSon){
            Toast.makeText(this, "Ozgina tushing", Toast.LENGTH_SHORT).show()
            binding.tvInfo.text ="Siz yozgan son biz o'ylangan sondan katta "
        }
    }
}