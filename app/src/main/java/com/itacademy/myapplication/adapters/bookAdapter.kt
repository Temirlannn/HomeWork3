package com.itacademy.myapplication.adapters

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.myapplication.R
import com.itacademy.myapplication.entites.Book

class bookAdapter(
    private val array: Array<Book>,
    val context: FragmentActivity
): RecyclerView.Adapter<bookAdapter.ViewHolder>(){
    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_name_book)
        val author: TextView = view.findViewById(R.id.item_author_book)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_item, parent, false)
        return ViewHolder(view)    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.name.text = item.bookName
        holder.author.text = item.author
    }

    override fun getItemCount(): Int {
        return array.size
    }
}