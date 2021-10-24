package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val BOOKLIST_KEY = "books"

class BookListFragment : Fragment() {
    private lateinit var bookList: BookList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {(it.getParcelableArray(BOOKLIST_KEY) as BookList).also { bookList = it }}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_book_list, container, false)
        val recyclerView = layout.findViewById<RecyclerView>(R.id.recycerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val itemViewModel = ViewModelProvider(requireActivity()).get(BookViewModel::class.java)
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            itemViewModel.setItem(bookList.get(itemPosition))
        }

        recyclerView.adapter = BookListAdapter(bookList, onClickListener)

        return layout
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(books: Array<Book>) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(BOOKLIST_KEY, books)
                }
            }
    }
}