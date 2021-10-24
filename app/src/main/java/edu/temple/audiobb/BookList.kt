package edu.temple.audiobb

class BookList() {
    // array of Books
    var bookList = arrayListOf<Book>()
    //init empty
    //init given params, # of books, generated array

    fun add(_book:Book){
    }
    fun remove(_book:Book){
    }
    fun get(_index:Int) : Book{
        return Book("DaTitle","DaAuthor")
    }
    fun size():Int{
        return bookList.size
    }
}