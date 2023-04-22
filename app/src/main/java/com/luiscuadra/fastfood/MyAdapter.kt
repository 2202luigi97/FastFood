package com.luiscuadra.fastfood

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.luiscuadra.fastfood.databinding.ItemmenuBinding
import com.squareup.picasso.Picasso

class MyAdapter (private val context: Context, private val arrayList: java.util.ArrayList<Menu>):
    BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val binding = ItemmenuBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        var convertView = convertView
        convertView = binding.root

        binding.txtTitulo.text = arrayList[position].title
        if (arrayList[position].imgurl != null) {
            Picasso.get().load(arrayList[position].imgurl).into(binding.imageDestino);
        }

        return convertView
    }
}