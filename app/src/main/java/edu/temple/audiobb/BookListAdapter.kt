package edu.temple.audiobb

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class BookListAdapter(_bookList: BookList, _onClickListener: View.OnClickListener) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {
    private val bookList = _bookList
    private val ocl = _onClickListener

    class ViewHolder(_view: View, ocl: View.OnClickListener) : RecyclerView.ViewHolder(_view) {
        //val bookTitleView : TextView = _view.findViewById<TextView>(R.id.bookTitle)
        val bookTitleView : TextView = _view.apply { setOnClickListener(ocl) } as TextView
        //val bookAuthorView : TextView = _view.findViewById<TextView>(R.id.bookAuthor)
        val bookAuthorView : TextView = _view.apply{ setOnClickListener(ocl)} as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageView(parent.context).apply { layoutParams = ViewGroup.LayoutParams(300, 300) }, ocl)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bookTitleView.text = bookList.get(position).getTitle()
        holder.bookAuthorView.text = bookList.get(position).getAuthor()
        //holder.bookTitleView.setImageResource(bookList[position].getTitle().toString())
    }

    override fun getItemCount(): Int {
        return bookList.size()
    }
}