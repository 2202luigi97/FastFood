package com.luiscuadra.fastfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luiscuadra.fastfood.databinding.ActivityListmenuBinding
import com.luiscuadra.fastfood.databinding.ActivityListpolloBinding

class listpollo : AppCompatActivity() {

    var menus: ArrayList<Menu> = ArrayList()
    lateinit var binding: ActivityListpolloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListpolloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menus.add(
            Menu(
                "Pierna de Pollo",
                "C$70", "https://thumbs.dreamstime.com/b/patas-de-pollo-fritas-crujientes-y-sin-aliento-aisladas-en-fondo-blanco-185063345.jpg"
            )
        )
        menus.add(
            Menu(
                "Pechuga de Pollo",
                "C$90",
                "https://thumbs.dreamstime.com/b/pechuga-de-pollo-frita-en-el-fondo-blanco-41891692.jpg"
            )
        )
        menus.add(
            Menu(
                "Alitas de Pollo",
                "C$120",
                "https://w7.pngwing.com/pngs/647/356/png-transparent-fried-chicken-wings-product-kind-fried-chicken-wings-chicken-wings.png"
            )
        )
        val adaptador = MyAdapter(listpollo@ this, menus)
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