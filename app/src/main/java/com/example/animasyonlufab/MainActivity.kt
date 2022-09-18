package com.example.animasyonlufab

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fabDurum = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabBirinci.scaleX = 0.0f
        fabBirinci.scaleY = 0.0f

        fabIkinci.scaleX = 0.0f
        fabIkinci.scaleY = 0.0f

        fabMain.setOnClickListener {
            if (fabDurum){
                val rotateFabMain = ObjectAnimator.ofFloat(fabMain,"rotation",45.0f,0.0f)
                val scaleXFabBirinci = ObjectAnimator.ofFloat(fabBirinci,"scaleX",1.0f,0.0f)
                val scaleYFabBirinci = ObjectAnimator.ofFloat(fabBirinci,"scaleY",1.0f,0.0f)
                val scaleXFabIkinci = ObjectAnimator.ofFloat(fabIkinci,"scaleX",1.0f,0.0f)
                val scaleYFabIkinci = ObjectAnimator.ofFloat(fabIkinci,"scaleY",1.0f,0.0f)

                val cokluAnimasyon = AnimatorSet().apply {
                    duration = 500
                    playTogether(rotateFabMain,scaleXFabBirinci,scaleYFabBirinci,scaleXFabIkinci,scaleYFabIkinci)
                }
                cokluAnimasyon.start()
                fabDurum = false
            }else{
                val rotateFabMain = ObjectAnimator.ofFloat(fabMain,"rotation",0.0f,45.0f)
                val scaleXFabBirinci = ObjectAnimator.ofFloat(fabBirinci,"scaleX",0.0f,1.0f)
                val scaleYFabBirinci = ObjectAnimator.ofFloat(fabBirinci,"scaleY",0.0f,1.0f)
                val scaleXFabIkinci = ObjectAnimator.ofFloat(fabIkinci,"scaleX",0.0f,1.0f)
                val scaleYFabIkinci = ObjectAnimator.ofFloat(fabIkinci,"scaleY",0.0f,1.0f)

                val cokluAnimasyon = AnimatorSet().apply {
                    duration = 500
                    playTogether(rotateFabMain,scaleXFabBirinci,scaleYFabBirinci,scaleXFabIkinci,scaleYFabIkinci)
                }
                cokluAnimasyon.start()
                fabDurum = true
            }
        }
        fabBirinci.setOnClickListener {
            Toast.makeText(this@MainActivity,"Fab Birinci Tıklandı",Toast.LENGTH_SHORT).show()
        }
        fabIkinci.setOnClickListener {
            Toast.makeText(this@MainActivity,"Fab İkinci Tıklandı",Toast.LENGTH_SHORT).show()
        }
    }
}