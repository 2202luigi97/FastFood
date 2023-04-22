package com.luiscuadra.fastfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luiscuadra.fastfood.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun Hamburguesas(view: View) {
        val intent = Intent(this, listmenu::class.java)
        startActivity(intent)

    }
    fun Hotdog(view: View) {
        val intent = Intent(this, listhotdog::class.java)
        startActivity(intent)

    }
    fun Pollo(view: View) {
        val intent = Intent(this, listpollo::class.java)
        startActivity(intent)

    }
    fun Gaceosas(view: View) {
        val intent = Intent(this, listgaceosa::class.java)
        startActivity(intent)

    }
    fun Pizza(view: View) {
        val intent = Intent(this, listpizza::class.java)
        startActivity(intent)

    }

}