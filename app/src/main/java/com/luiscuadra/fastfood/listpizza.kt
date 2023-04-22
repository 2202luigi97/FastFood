package com.luiscuadra.fastfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luiscuadra.fastfood.databinding.ActivityListpizzaBinding

class listpizza : AppCompatActivity() {

    var menus: ArrayList<Menu> = ArrayList()
    lateinit var binding: ActivityListpizzaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListpizzaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menus.add(
            Menu(
                "Pizza Pepperoni",
                "C$30", "https://www.pngall.com/wp-content/uploads/4/Pepperoni-Dominos-Pizza-PNG-Picture.png"
            )
        )
        menus.add(
            Menu(
                "Pizza de Jamon",
                "C$30",
                "https://valentispizza.net/wp-content/uploads/2017/04/jamon-salami.jpg"
            )
        )
        menus.add(
            Menu(
                "Pizza Hawaiana",
                "C$120",
                "https://ilpappardelle.files.wordpress.com/2013/05/a846f-especialidades_hawaiana.png"
            )
        )
        val adaptador = MyAdapter(listpizza@ this, menus)
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
    }
}