package com.luiscuadra.fastfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luiscuadra.fastfood.databinding.ActivityListgaceosaBinding

class listgaceosa : AppCompatActivity() {

    var menus: ArrayList<Menu> = ArrayList()
    lateinit var binding: ActivityListgaceosaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListgaceosaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menus.add(
            Menu(
                "Coca Cola",
                "C$30",
                "https://w7.pngwing.com/pngs/897/836/png-transparent-coca-cola-600-fizzy-drinks-diet-coke-fanta-gaseosas-cola-beverages-soft-drink.png"
            )
        )
        menus.add(
            Menu(
                "Fresco de Naranja",
                "C$20",
                "https://img.freepik.com/vector-premium/botella-jugo-naranja-realista-pajita-tapa-sobre-fondo-transparente_208581-858.jpg"
            )
        )
        menus.add(
            Menu(
                "Gatorade",
                "C$40",
                "https://img2.freepng.es/20190331/oxz/kisspng-sports-energy-drinks-the-gatorade-company-portab-gatorade-transparent-amp-png-clipart-free-downlo-5ca161009b0029.8740095615540800006349.jpg"
            )
        )
        val adaptador = MyAdapter(listgaceosa@ this, menus)
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