package com.luiscuadra.fastfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luiscuadra.fastfood.databinding.ActivityListhotdogBinding

class listhotdog : AppCompatActivity() {
    var menus: ArrayList<Menu> = ArrayList()
    lateinit var binding: ActivityListhotdogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListhotdogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menus.add(
            Menu(
                "Hotdog Clásico",
                "C$100", "https://assets.stickpng.com/thumbs/580b57fcd9996e24bc43c1b2.png"
            )
        )
        menus.add(
            Menu(
                "Hotdog CheseMost",
                "C$150",
                "https://www.pngplay.com/wp-content/uploads/7/Hot-Dog-No-Background.png"
            )
        )
        val adaptador = MyAdapter(listhotdog@ this, menus)
        binding.ListaMenu.adapter = adaptador

        //Click a cada elemento del ListView
        binding.ListaMenu.setOnItemClickListener { parent, view, position, id ->


            val intent = Intent(this, menudetalle::class.java).apply {
                putExtra("TITULO", menus[id.toInt()].title)
                putExtra("PRECIO", menus[id.toInt()].precio)
                putExtra("FOTO", menus[id.toInt()].imgurl)
            }
            startActivity(intent)
        }
        fun Volver(view: View) {
            finish()
        }
    }
}