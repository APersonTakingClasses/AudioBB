package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), BookListFragment.BookSelectedInterface {

    private val isSingleContainer : Boolean by lazy{
        findViewById<View>(R.id.container2) == null
    }

    private val selectedBookViewModel : BookViewModel by lazy {
        ViewModelProvider(this).get(BookViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Grab test data
        val bookList = generateBookList()

        // If we're switching from one container to two containers
        // clear BookDetailsFragment from container1
        if (supportFragmentManager.findFragmentById(R.id.container1) is BookDetailsFragment) {
            supportFragmentManager.popBackStack()
        }

        // If this is the first time the activity is loading, go ahead and add a BookListFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container1, BookListFragment.newInstance(bookList))
                .commit()
        } else
        // If activity loaded previously, there's already a BookListFragment
        // If we have a single container and a selected book, place it on top
            if (isSingleContainer && selectedBookViewModel.getSelectedBook().value != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container1, BookDetailsFragment())
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit()
            }

        // If we have two containers but no BookDetailsFragment, add one to container2
        if (!isSingleContainer && supportFragmentManager.findFragmentById(R.id.container2) !is BookDetailsFragment)
            supportFragmentManager.beginTransaction()
                .add(R.id.container2, BookDetailsFragment())
                .commit()

    }
    override fun onBackPressed() {
        // Backpress clears the selected book
        selectedBookViewModel.setSelectedBook(null)
        super.onBackPressed()
    }

    override fun bookSelected() {
        // Perform a fragment replacement if we only have a single container
        // when a book is selected

        if (isSingleContainer) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, BookDetailsFragment())
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit()
        }
    }


    private fun generateBookList(): BookList {
        val bookList = BookList()
        val titleArray:Array<String> = this.resources.getStringArray(R.array.title_array)
        val authorArray:Array<String> = this.resources.getStringArray(R.array.author_array)
        bookList.add(Book(titleArray[0], authorArray[0]))
        bookList.add(Book(titleArray[1], authorArray[1]))
        bookList.add(Book(titleArray[2], authorArray[2]))
        bookList.add(Book(titleArray[3], authorArray[3]))
        bookList.add(Book(titleArray[4], authorArray[4]))
        bookList.add(Book(titleArray[5], authorArray[5]))
        bookList.add(Book(titleArray[6], authorArray[6]))
        bookList.add(Book(titleArray[7], authorArray[7]))
        bookList.add(Book(titleArray[8], authorArray[8]))
        bookList.add(Book(titleArray[9], authorArray[9]))
        return bookList
    }
}