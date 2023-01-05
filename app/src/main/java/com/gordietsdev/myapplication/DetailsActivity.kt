package com.gordietsdev.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.gordietsdev.myapplication.main_recyclerview.Film

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initData()
    }

    private fun initData() {
        val film = intent.extras?.get("film") as Film

        //Устанавливаем заголовок
        findViewById<androidx.appcompat.widget.Toolbar>(R.id.details_toolbar).title = film.title
        //Устанавливаем картинку
        findViewById<AppCompatImageView>(R.id.details_poster).setImageResource(film.poster)
        //Устанавливаем описание
        findViewById<TextView>(R.id.details_description).text = film.description
    }
}