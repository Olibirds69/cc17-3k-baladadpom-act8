package com.example.bookshelfapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelfapp.repo.BookRepository
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun fetchBooks(query: String) {
        viewModelScope.launch {
            _books.value = BookRepository.searchBooks(query)
        }
    }
}
