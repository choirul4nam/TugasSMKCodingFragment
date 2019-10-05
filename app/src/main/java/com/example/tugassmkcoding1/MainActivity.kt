package com.example.tugassmkcoding1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var layout = 1
    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_next = findViewById<Button>(R.id.btn_next)
        val btn_prev = findViewById<Button>(R.id.btn_prev)

        showFragmentPertama()
        btn_prev.setEnabled(false)
        btn_next.setOnClickListener({
            if(layout==1) {
                btn_prev.setEnabled(true)
                showFragmentKedua()
            }
            else {
                btn_prev.setEnabled(true)
                btn_next.setEnabled(false)
                showFragmentKetiga()}
        })
        btn_prev.setOnClickListener({
            if(layout == 3){
                showFragmentKedua()
                btn_next.setEnabled(true)
            } else {
                btn_next.setEnabled(true)
                btn_prev.setEnabled(false)
                showFragmentPertama()
            }
        })
    }

    fun showFragmentPertama(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentPertama()
        transaction.replace(R.id.fragmentLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        layout = 1
    }
    fun showFragmentKedua(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentKedua()
        transaction.replace(R.id.fragmentLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        layout = 2
    }
    fun showFragmentKetiga(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentKetiga()
        transaction.replace(R.id.fragmentLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        layout = 3
    }
}
