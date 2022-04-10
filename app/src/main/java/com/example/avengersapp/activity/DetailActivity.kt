package com.example.avengersapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.example.avengersapp.R
import com.example.avengersapp.model.AvengerCharacter

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_DETAIL_EXTRAS = "detail_extras"
    }

    private lateinit var avengerImage: ImageView
    private lateinit var avengerName: TextView
    private lateinit var avengerDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        configureViews()
        intent.extras?.getParcelable<AvengerCharacter>(KEY_DETAIL_EXTRAS)?.let {
            updateViews(it)
        }
    }


    private fun configureViews () {
        avengerImage = findViewById(R.id.imageViewAvengerCharacter)
        avengerName = findViewById(R.id.textViewCharacterName)
        avengerDescription = findViewById(R.id.textViewCharacterDescription)

    }

    private fun updateViews (character: AvengerCharacter) {
        val imageDrawableID = resources.getIdentifier(character.image, "drawable", packageName)
        avengerImage.setImageDrawable(androidx.appcompat.content.res.AppCompatResources.getDrawable(this, imageDrawableID))
        avengerName.text = character.name
        avengerDescription.text = character.description
    }

}