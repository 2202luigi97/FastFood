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
                "https://admin.consumo.com.co/backend/admin/backend/web/archivosDelCliente/items/images/20210208121219-Bebidas-Gaseosas-y-Maltas-GASEOSA-COCA-COLA-X-600-ML-5939202102081212197120.png"
            )
        )
        menus.add(
            Menu(
                "Fresco de Naranja",
                "C$20",
                "https://www.pnguniverse.com/wp-content/uploads/2020/10/Jugo-de-naranja.png"
            )
        )
        menus.add(
            Menu(
                "Gatorade",
                "C$40",
                "https://images.squarespace-cdn.com/content/v1/54e22d6be4b00617871820ca/1594743773195-1LHT4ME1I635H18TLGS3/28oz+Fruit+Punchq.png?format=500w"
            )
        )

        menus.add(
            Menu(
                "Gatorade",
                "C$40",
                "https://images.squarespace-cdn.com/content/v1/54e22d6be4b00617871820ca/1594743773195-1LHT4ME1I635H18TLGS3/28oz+Fruit+Punchq.png?format=500w"
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