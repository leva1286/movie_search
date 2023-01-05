package com.gordietsdev.myapplication.main_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gordietsdev.myapplication.R

class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Здесь у нас хранится список элементов для RV
    private val items = mutableListOf<Film>()

    // привязываем наш ViewHolder и передаем "надутую" верстку нашего фильма
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FileViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        )
    }

    // привязываем поля объекта Film к View из film_item.xml
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FileViewHolder -> {
                holder.bind(items[position])
                holder.itemView.setOnClickListener {
                    clickListener.click(items[position])
                }
            }
        }
    }

    // метод возвращает количество элементов в списке RV
    override fun getItemCount(): Int = items.size

    //Метод для добавления объектов в наш список
    fun addItems(list: List<Film>) {
        val filmDiff = FilmDiffUtil(items, list)
        val diffResult = DiffUtil.calculateDiff(filmDiff)
        items.clear()
        items.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    //Интерфейс для обработки кликов
    interface OnItemClickListener {
        fun click(film: Film)
    }
}