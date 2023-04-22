package com.luiscuadra.fastfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luiscuadra.fastfood.databinding.ActivityListmenuBinding

class listmenu : AppCompatActivity() {
    var menus: ArrayList<Menu> = ArrayList()
    lateinit var binding: ActivityListmenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menus.add(
            Menu(
                "Hamburguesa de Res",
                "C$120", "https://static3.depositphotos.com/1000691/109/i/950/depositphotos_1098427-stock-photo-cheeseburger.jpg"
            )
        )
        menus.add(
            Menu(
                "Hamburguesa de Pollo",
                "C$150",
                "https://img2.freepng.es/20180605/ljs/kisspng-hamburger-chicken-nugget-whopper-crispy-fried-chic-chiken-burger-5b1687e6b7b1d6.6667528315282032387524.jpg"
            )
        )
        menus.add(
            Menu(
                "Hamburguesa Mixta",
                "C$200",
                "https://img2.freepng.es/20180328/vlq/kisspng-cheeseburger-bacon-hamburger-wrap-hot-dog-bacon-5abba6a0b0b5c8.9053149315222473287238.jpg"
            )
        )
        val adaptador = MyAdapter(listmenu@ this, menus)
        binding.ListaMenu.adapter = adaptador

        //Click a cada elemento del ListView
        binding.ListaMenu.setOnItemClickListener { parent, view, position, id ->
            //Toast.makeText(this, "Hizo clickl en ${peliculas[id.toInt()].titulo}", Toast.LENGTH_SHORT).show()

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