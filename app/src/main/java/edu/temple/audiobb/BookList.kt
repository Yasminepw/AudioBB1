package edu.temple.audiobb

import java.io.Serializable

class BookList : Serializable {
    private var listOfBooks = mutableListOf<Book>()

    fun add(book: Book) {
        listOfBooks.add(book)
    }
    fun remove(book: Book) {
        listOfBooks.remove(book)
    }

    fun get(index : Int) : Book {
        return listOfBooks[index]
    }

    fun size() : Int {
        return listOfBooks.size
    }
}