package com.example.opcion1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CreatePostActivity : AppCompatActivity() {

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        val btnSelectImage: Button = findViewById(R.id.btnSelectImage)
        val imgSelected: ImageView = findViewById(R.id.imgSelected)
        val btnPost: Button = findViewById(R.id.btnPost)

        btnSelectImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 100)
        }

        btnPost.setOnClickListener {
            val name = findViewById<EditText>(R.id.etName).text.toString()
            val breed = findViewById<EditText>(R.id.etBreed).text.toString()
            val characteristics = findViewById<EditText>(R.id.etCharacteristics).text.toString()
            val contact = findViewById<EditText>(R.id.etContact).text.toString()

            if (name.isNotEmpty() && breed.isNotEmpty() && characteristics.isNotEmpty() && contact.isNotEmpty() && imageUri != null) {
                // Crear el objeto Post y agregarlo al repositorio
                val post = PostRepository.Post(
                    name = name,
                    breed = breed,
                    characteristics = characteristics,
                    contact = contact,
                    imageUri = imageUri.toString()
                )
                PostRepository.addPost(post)

                Toast.makeText(this, "Publicación creada", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            imageUri = data?.data
            findViewById<ImageView>(R.id.imgSelected).setImageURI(imageUri)
        }
    }
}
