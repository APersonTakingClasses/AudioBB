package edu.temple.audiobb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel: ViewModel() {
    private val itemLiveData = MutableLiveData<Book>()

    fun getItem () : LiveData<Book> {
        return itemLiveData
    }

    fun setItem(book: Book) {
        itemLiveData.value = book
    }
}