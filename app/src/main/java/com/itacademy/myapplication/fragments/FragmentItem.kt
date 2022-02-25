package com.itacademy.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.myapplication.Appl
import com.itacademy.myapplication.R
import com.itacademy.myapplication.adapters.bookAdapter


class FragmentItem : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  dbBook = Appl.instance?.getDatabase()?.bookDao()
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = bookAdapter(dbBook!!.getAllBooks(), requireActivity())
    }
}