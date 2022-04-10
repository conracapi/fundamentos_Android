package com.example.avengersapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.avengersapp.R
import com.example.avengersapp.model.AvengerCharacter
import com.example.avengersapp.model.AvengerCharacters

class AvengersCharactersVillainsAdapter (private val items: AvengerCharacters, private val listener: ItemClickListener? = null): RecyclerView.Adapter<AvengersCharactersVillainsAdapter.AvengersCharactersGridViewHolder>() {

    class AvengersCharactersGridViewHolder (private val view: View, private val listener: ItemClickListener? = null): RecyclerView.ViewHolder(view) {

        private var avengerCharacterName = view.findViewById<TextView>(R.id.textViewCharacterName)
        private var avengerCharacterImage = view.findViewById<ImageView>(R.id.imageViewAvengerCharacter)

        fun updateViews (item: AvengerCharacter) {

            view.setOnClickListener {
                listener?.onItemClickListener(item)
            }

            with(view.context) {
                val imageDrawableID = resources.getIdentifier(item.image, "drawable", packageName)
                avengerCharacterImage.setImageDrawable(AppCompatResources.getDrawable(this, imageDrawableID))
            }

            avengerCharacterName.text = item.name
        }

    }



    // ...

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvengersCharactersGridViewHolder {
        val itemGrid = LayoutInflater.from(parent.context).inflate(R.layout.cell_villain_avenger_character, parent, false)
        return AvengersCharactersGridViewHolder(itemGrid, listener)

    }

    override fun onBindViewHolder(holder: AvengersCharactersGridViewHolder, position: Int) {
        holder.updateViews(items[position])
    }




}