package com.android.example.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import entity.City
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val i = intent.getIntExtra("position",0)
        val detailImages= arrayOf(R.drawable.paris_detail,R.drawable.london_detail,R.drawable.barcelone_detail,R.drawable.istanbul_detail,R.drawable.rome_detail)
        val namesTab = resources.getStringArray(R.array.cities)
        val touristsTab = resources.getStringArray(R.array.tourists)
        val placesTab = resources.getStringArray(R.array.places)
        val descTab = resources.getStringArray(R.array.description)
        val city = City(detailImage = detailImages[i],name = namesTab[i],touristNumber = touristsTab[i],places = placesTab,description = descTab[i])
        imageDetail.setImageResource(city.detailImage)
        nameDetail.text = city.name
        numbertouristDetail.text  =  if (city.touristNumber.toString()!="") city.touristNumber + getString(R.string.touristText) else  ""
        description.text = city.description
        places.text = if(city.places.size!=0) getString(R.string.places)+city.places.joinToString(separator = ", ") else ""

    }
}
