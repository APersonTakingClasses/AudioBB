package edu.temple.audiobb

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

class Book(_title:String, _author:String):Parcelable {
    private var title = _title
    private var author = _author

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString()
    )
    override fun describeContents(): Int {
        return 0
    }
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(title)
        p0?.writeString(author)
    }
    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }
        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }

    //usability functions
    fun getTitle() :  String { return title }
    fun getAuthor() :  String { return author }
    fun changeTitle(_t : String){ title = _t}
    fun changeAuthor(_a : String){ author = _a}

}

// val book1 = Book("DaRules","DaAuthor")