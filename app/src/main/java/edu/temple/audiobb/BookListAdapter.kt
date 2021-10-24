package edu.temple.audiobb

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class BookListAdapter(_bookList: BookList, _onClickListener: View.OnClickListener) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {
    private val bookList = _bookList
    val ocl = _onClickListener

    class ViewHolder(_view: ImageView, ocl: View.OnClickListener) : RecyclerView.ViewHolder(_view) {
        val bookTitleView = _view.apply { setOnClickListener(ocl) }
        val bookAuthorView = _view.apply { setOnClickListener(ocl) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageView(parent.context).apply { layoutParams = ViewGroup.LayoutParams(300, 300) }, ocl)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bookTitleView.text = bookList.get(position).getTitle()
        holder.bookAuthorView?.text = bookList.get(position).getAuthor()
    }

    override fun getItemCount(): Int {
        return bookList.size()
    }
}