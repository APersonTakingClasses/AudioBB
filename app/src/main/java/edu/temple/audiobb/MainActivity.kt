package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = this.resources.getString(R.string.app_name)
    }

    fun generateBooks(): Array<Book> {
        // generate an array of ten books
        // input into BookList.newInstance()
        val titleArray: Array<String> = this.resources.getStringArray(R.array.titleArray)
        val authorArray: Array<String> = this.resources.getStringArray(R.array.authorArray)
        return arrayOf(
            Book(titleArray[0], authorArray[0]),
            Book(titleArray[1], authorArray[1]),
            Book(titleArray[2], authorArray[2]),
            Book(titleArray[3], authorArray[3]),
            Book(titleArray[4], authorArray[4]),
            Book(titleArray[5], authorArray[5]),
            Book(titleArray[6], authorArray[6]),
            Book(titleArray[7], authorArray[7]),
            Book(titleArray[8], authorArray[8]),
            Book(titleArray[9], authorArray[9])
        )
    }
}