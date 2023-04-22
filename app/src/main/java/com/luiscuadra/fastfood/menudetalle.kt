package com.luiscuadra.fastfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luiscuadra.fastfood.databinding.ActivityMenudetalleBinding
import com.squareup.picasso.Picasso

class menudetalle : AppCompatActivity() {
    private lateinit var binding: ActivityMenudetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMenudetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titulo = intent.getStringExtra("TITULO")
        val precio = intent.getStringExtra("PRECIO")
        val foto = intent.getStringExtra("FOTO")

        binding.txtTitle.text = titulo
        binding.txtdesc.text = precio
        Picasso.get().load(foto).into(binding.imgfondo);
    }
    fun finalizar(view: View){
        finish()
    }

}