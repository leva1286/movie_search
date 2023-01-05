package com.gordietsdev.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.gordietsdev.myapplication.main_recyclerview.Film

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }
    private fun initData() {
        val film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        view?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.details_toolbar)?.title = film.title
        //Устанавливаем картинку
        view?.findViewById<AppCompatImageView>(R.id.details_poster)?.setImageResource(film.poster)
        //Устанавливаем описание
        view?.findViewById<TextView>(R.id.details_description)?.text = film.description
    }
}