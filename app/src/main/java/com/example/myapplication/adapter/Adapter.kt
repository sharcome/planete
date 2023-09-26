package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.PlanetData

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.titletxt)
        var planetimg = view.findViewById<ImageView>(R.id.planet_img)
        var galaxy = view.findViewById<TextView>(R.id.galaxy)
        var distance = view.findViewById<TextView>(R.id.distance)
        var gravity = view.findViewById<TextView>(R.id.gravity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage: Int? = null
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,PlanetDetail::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)

        }
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + " m km"
        holder.gravity.text = planet[position].gravity + " m/ss"

//
        when (planet[position].title?.toLowerCase()) {
            "mars" -> {
                dummyImage = R.drawable.ic_mars
            }
            "neptune" -> {
                dummyImage = R.drawable.ic_neptune
            }
            "earth" -> {
                dummyImage = R.drawable.ic_earth
            }
            "moon" -> {
                dummyImage = R.drawable.ic_moon
            }

            "venus"-> {
                dummyImage = R.drawable.ic_venus
            }

            "jupiter" -> {
                dummyImage = R.drawable.ic_jupiter
            }
            "saturn" -> {
                dummyImage = R.drawable.ic_saturn
            }
            "uranus" -> {
                dummyImage = R.drawable.ic_uranus
            }
            "mercury" -> {
                dummyImage = R.drawable.ic_mercuriy
            }
            "sun" -> {
                dummyImage = R.drawable.ic_sun
            }
        }
        dummyImage?.let { holder.planetimg.setImageResource(it) }


    }

    override fun getItemCount(): Int {
        return planet.size
    }
}