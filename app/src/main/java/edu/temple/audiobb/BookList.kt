package edu.temple.audiobb

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class BookList() {
    // arrayList of Book objects
    // init empty bookList
    private var bookList = arrayListOf<Book>()
    fun generateBookList( bookArray : Array<Book>){
        // generate bookList on generateBooks from mainactivity
        // generate bookList if passed a book array of any size
        for(book in bookArray) bookList.add(book)
    }

    // usability functions
    // encapsulation of arrayList functions
    fun add(_book:Book){ bookList.add(_book) }
    fun remove(_book:Book){ bookList.remove(_book) }
    fun get(_index:Int) : Book{ return bookList.get(_index) }
    fun size():Int{ return bookList.size }
}