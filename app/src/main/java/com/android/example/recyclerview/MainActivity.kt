package com.android.example.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import entity.City
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CityAdapter(this,loadData())
        val itemDecor = DividerItemDecoration(this,1)
        recyclerView.addItemDecoration(itemDecor)

    }



    fun loadData():List<City> {

        //val detailImages = arrayOf(R.drawable.paris_detail,R.drawable.london_detail,R.drawable.barcelone_detail,R.drawable.istanbul_detail,R.drawable.rome_detail)
        val namesTab = resources.getStringArray(R.array.cities)
        val touristsTab = resources.getStringArray(R.array.tourists)
        //val placesTab = resources.getStringArray(R.array.places)
        //val descTab = resources.getStringArray(R.array.description)
        val imagesTab = arrayOf(R.drawable.paris_list,R.drawable.london_list,R.drawable.barcelona_list,R.drawable.istanbul_list,R.drawable.roma_list)
        val list = mutableListOf<City>()
        for (i in 0..imagesTab.size-1) {
            list.add(City(listImage = imagesTab[i], name = namesTab[i], touristNumber = touristsTab[i]))

        }
        return  list
    }
}
