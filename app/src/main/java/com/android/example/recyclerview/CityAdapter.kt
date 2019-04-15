package com.android.example.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import entity.City

class CityAdapter(val context:Context,var cities:List<City>):RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.city_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageList.setImageResource(cities.get(position).listImage)
        holder.name.setText(cities.get(position).name)
        holder.numberTourist.setText("${cities.get(position).touristNumber}"+context.getString(R.string.touristText))
        holder.itemView.setOnClickListener { view ->
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("position",position)
            context.startActivity(intent)

        }
    }

    override fun getItemCount() = cities.size


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var imageList = view.findViewById(R.id.listimage) as ImageView
    val name = view.findViewById<TextView>(R.id.name) as TextView
    val numberTourist = view.findViewById<TextView>(R.id.numbertourist) as TextView



}



