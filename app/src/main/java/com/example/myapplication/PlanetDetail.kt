package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityPlanetDetailBinding
import com.example.myapplication.model.PlanetData

class PlanetDetail : AppCompatActivity() {
    lateinit var viewBinding: ActivityPlanetDetailBinding
    private lateinit var obj:PlanetData
    private var planetImg:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityPlanetDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }

        obj= intent.getParcelableExtra("planet")!!
        planetImg=intent.getIntExtra("planetImage",-1)
        setData(obj, planetImg!!)

        viewBinding.buttonInfo.setOnClickListener{
            val intent=Intent(this,finalActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setData(obj: PlanetData, planetImg:Int)
    {
        viewBinding.titleInfo.text=obj.title
        viewBinding.distanceInfo.text=obj.distance+"m km"
        viewBinding.gravityInfo.text=obj.gravity+" m/ss"
        viewBinding.overviewInfo.text=obj.overview
        viewBinding.galaxyInfo.text=obj.galaxy
        viewBinding.planetImgInfo.setImageResource(planetImg)


    }
}