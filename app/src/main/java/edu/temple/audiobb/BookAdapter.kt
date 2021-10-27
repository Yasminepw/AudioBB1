package edu.temple.audiobb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val bookList: BookList, private val myOnClick : (position: Int) -> Unit) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    class ViewHolder(itemView: View, val myOnClick : (position: Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val bookTitleTextView: TextView = itemView.findViewById(R.id.bookTitleRecyclerTextView)
        val bookDetailsTextView: TextView = itemView.findViewById(R.id.bookDetailsRecyclerTextView)
        init {
            itemView.setOnClickListener {
                myOnClick(adapterPosition)
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_recycler_view, parent, false)
        return ViewHolder(view, myOnClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bookTitleTextView.text = bookList.get(position).title
        holder.bookDetailsTextView.text = bookList.get(position).author
    }

    override fun getItemCount() = bookList.size()

}
