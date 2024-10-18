package com.example.opcion1

object PostRepository {
    // Almacena las publicaciones en una lista en memoria
    val posts: MutableList<Post> = mutableListOf()

    // Clase que define una publicación
    data class Post(
        val name: String,
        val breed: String,
        val characteristics: String,
        val contact: String,
        val imageUri: String? = null
    )

    // Método para agregar una nueva publicación
    fun addPost(post: Post) {
        posts.add(post)
    }
}
