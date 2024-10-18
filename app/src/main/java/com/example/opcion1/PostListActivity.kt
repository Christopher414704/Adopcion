package com.example.opcion1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class PostListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        val lvPosts: ListView = findViewById(R.id.lvPosts)
        updatePostList(lvPosts)

        lvPosts.setOnItemClickListener { _, _, position, _ ->
            val selectedPost = PostRepository.posts[position]

            // Crear un Intent para abrir PostDetailActivity y pasar los detalles de la publicación
            val intent = Intent(this, PostDetailActivity::class.java).apply {
                putExtra("name", selectedPost.name)
                putExtra("breed", selectedPost.breed)
                putExtra("characteristics", selectedPost.characteristics)
                putExtra("contact", selectedPost.contact)
                putExtra("imageUri", selectedPost.imageUri ?: "")
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val lvPosts: ListView = findViewById(R.id.lvPosts)
        updatePostList(lvPosts)
    }

    private fun updatePostList(listView: ListView) {
        val postStrings = PostRepository.posts.map { post ->
            "Nombre: ${post.name}, Raza: ${post.breed}, Contacto: ${post.contact}"
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, postStrings)
        listView.adapter = adapter
    }
}
