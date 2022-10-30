package com.android.example.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.recyclerview.databinding.CityLayoutBinding

class CityAdapter(val context:Context,var cities:List<City>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CityLayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.apply {
            listimage.setImageResource(cities.get(position).listImage)
            name.setText(cities.get(position).name)
            numbertourist.setText("${cities.get(position).touristNumber}"+context.getString(R.string.touristText))
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("position",position)
            context.startActivity(intent)

        }
    }

    override fun getItemCount() = cities.size


}

class ViewHolder(val binding: CityLayoutBinding) : RecyclerView.ViewHolder(binding.root) {


}



