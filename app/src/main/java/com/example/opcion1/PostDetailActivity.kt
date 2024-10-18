package com.example.opcion1

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PostDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val name = intent.getStringExtra("name") ?: "No disponible"
        val breed = intent.getStringExtra("breed") ?: "No disponible"
        val characteristics = intent.getStringExtra("characteristics") ?: "No disponible"
        val contact = intent.getStringExtra("contact") ?: "No disponible"
        val imageUri = intent.getStringExtra("imageUri")

        val tvName: TextView = findViewById(R.id.tvName)
        val tvBreed: TextView = findViewById(R.id.tvBreed)
        val tvCharacteristics: TextView = findViewById(R.id.tvCharacteristics)
        val tvContact: TextView = findViewById(R.id.tvContact)
        val imgPost: ImageView = findViewById(R.id.imgPost)

        tvName.text = name
        tvBreed.text = breed
        tvCharacteristics.text = characteristics
        tvContact.text = contact

        // Mostrar la imagen si la URI no es vacía
        if (!imageUri.isNullOrEmpty()) {
            try {
                imgPost.setImageURI(Uri.parse(imageUri))
            } catch (e: Exception) {
                e.printStackTrace()
                imgPost.setImageResource(R.drawable.placeholder_image) // Mostrar un placeholder si falla la carga de la imagen
            }
        } else {
            imgPost.setImageResource(R.drawable.placeholder_image)
        }
    }
}
