package com.example.bookshelfapp

data class Book(
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>?,
    val description: String?,
    val imageLinks: ImageLinks?,
    val infoLink: String?

)

data class ImageLinks(
    val thumbnail: String
)