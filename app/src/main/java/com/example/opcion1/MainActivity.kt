package com.example.opcion1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCreatePost: Button = findViewById(R.id.btnCreatePost)
        val btnViewPosts: Button = findViewById(R.id.btnViewPosts)

        btnCreatePost.setOnClickListener {
            startActivity(Intent(this, CreatePostActivity::class.java))
        }

        btnViewPosts.setOnClickListener {
            startActivity(Intent(this, PostListActivity::class.java))
        }
    }
}
