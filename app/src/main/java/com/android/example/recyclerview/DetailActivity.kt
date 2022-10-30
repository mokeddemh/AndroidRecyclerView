package com.android.example.recyclerview


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.example.recyclerview.databinding.ActivityDetailBinding
import com.android.example.recyclerview.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val i = intent.getIntExtra("position",0)
        val detailImages= arrayOf(R.drawable.paris_detail,R.drawable.london_detail,R.drawable.barcelone_detail,R.drawable.istanbul_detail,R.drawable.rome_detail)
        val namesTab = resources.getStringArray(R.array.cities)
        val touristsTab = resources.getStringArray(R.array.tourists)
        val placesTab = resources.getStringArray(R.array.places)
        val descTab = resources.getStringArray(R.array.description)
        val city = City(detailImage = detailImages[i],name = namesTab[i],touristNumber = touristsTab[i],places = placesTab,description = descTab[i])
        binding.imageDetail.setImageResource(city.detailImage)
        binding.nameDetail.text = city.name
        binding.numbertouristDetail.text  =  if (city.touristNumber.toString()!="") city.touristNumber + getString(R.string.touristText) else  ""
        binding.description.text = city.description
        binding.places.text = if(city.places.size!=0) getString(R.string.places)+city.places.joinToString(separator = ", ") else ""

    }
}
