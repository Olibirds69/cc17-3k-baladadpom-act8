package com.example.bookshelfapp.repo


import com.example.bookshelfapp.Book
import com.example.bookshelfapp.api.BooksApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.delay
import java.io.IOException

object BookRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(BooksApiService::class.java)

    suspend fun searchBooks(query: String): List<Book> {
        return try {
            val response = api.searchBooks(query)
            response.items ?: emptyList()
        } catch (e: retrofit2.HttpException) {
            if (e.code() == 429) {
                delay(1000)
                emptyList()
            } else {
                emptyList()
            }
        } catch (e: IOException) {
            emptyList()
        }
    }
}
