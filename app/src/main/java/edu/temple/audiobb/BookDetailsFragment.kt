package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class BookDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout  = inflater.inflate(R.layout.fragment_book_details, container, false)

        val bookTitleView = layout.findViewById<TextView>(R.id.bookTitle)
        val bookAuthorView = layout.findViewById<TextView>(R.id.bookAuthor)

        ViewModelProvider(requireActivity())
            .get(BookViewModel::class.java)
            .getItem()
            .observe(requireActivity(), {
                bookTitleView.text = it.getTitle()
                bookAuthorView.text = it.getAuthor()
            })

        return layout
    }
}