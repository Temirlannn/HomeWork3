package com.itacademy.myapplication.fragments

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import com.itacademy.myapplication.Appl
import com.itacademy.myapplication.R
import com.itacademy.myapplication.databinding.FragmentAddBookBinding
import com.itacademy.myapplication.entites.Book
import java.net.DatagramPacket
import java.text.SimpleDateFormat

class AddBookF : Fragment(), AdapterView.OnItemSelectedListener {
    private var _binding: FragmentAddBookBinding? = null
    private val binding get() = _binding!!
    var idGenre: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbBook = Appl.instance?.getDatabase()?.bookDao()
        val dbGenre = Appl.instance?.getDatabase()?.genreDao()
        val getGenreName = dbGenre?.getNameGenre()

        spinnerGenre(binding.genreSelect, getGenreName!!)
        binding.genreSelect.onItemSelectedListener = this

        binding.addBookBtn.setOnClickListener {
            val book = Book(
                idBook = null,
                bookName = binding.bookName.text.toString(),
                author = binding.bookAuthor.text.toString(),
                publicationDate = binding.bookPublicationDate.text.toString(),
                pageAmount = binding.bookAmountPage.text.toString().toInt(),
                amount = binding.bookAmount.text.toString().toInt(),
                place = binding.bookPlace.text.toString(),
                fnGenreId = idGenre
            )
            dbBook?.addBook(book)

            Log.e("Get", "${dbBook?.getAllBooks()}")
        }

    }

    fun spinnerGenre(spinner: Spinner, list: List<String>) {
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
        spinner.adapter = adapter

    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val dbGenre = Appl.instance?.getDatabase()?.genreDao()
        val genre = dbGenre?.getAllGenre()
        for (i in genre!!) {
            if (parent?.selectedItem == i.name) {
                idGenre = i.idGenre
                Log.e("DDDD", idGenre.toString())
            }
        }
        Log.e("Err", genre.size.toString())

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}