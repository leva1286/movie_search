package com.gordietsdev.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.gordietsdev.myapplication.main_recyclerview.Film
import com.gordietsdev.myapplication.main_recyclerview.FilmListRecyclerAdapter
import com.gordietsdev.myapplication.main_recyclerview.TopSpacingItemDecoration

class MainActivity : AppCompatActivity() {

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private val filmsDataBase = listOf(
        Film(0,
            "The Shawshank Redemption",
            R.drawable.shawshank,
            "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."
        ),
        Film(1,
            "The Godfather",
            R.drawable.god_father,
            "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."
        ),
        Film(2,
            "The Dark Knight",
            R.drawable.dark_knight,
            "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."
        ),
        Film(3,
            "Pulp Fiction",
            R.drawable.pulp,
            "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption."
        ),
        Film(4,
            "Inception",
            R.drawable.inception,
            "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O."
        ),
        Film(5,
            "Hamilton",
            R.drawable.hamilton,
            "The real life of one of America's foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from the Richard Rodgers Theater with the original Broadway cast."
        ),
        Film(6,
            "Gisaengchung",
            R.drawable.parasites,
            "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan."
        ),
        Film(7,
            "Interstellar",
            R.drawable.interstellar,
            "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."
        ),
        Film(8,
            "Joker",
            R.drawable.joker,
            "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker."
        ),
        Film(9,
            "1917",
            R.drawable.seventy,
            "April 6th, 1917. As a regiment assembles to wage war deep in enemy territory, two soldiers are assigned to race against time and deliver a message that will stop 1,600 men from walking straight into a deadly trap."
        ),
        Film(10,
            "Avatar: The Way of Water",
            R.drawable.avatar,
            "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Na'vi race to protect their home."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigation()
        initRecyclerView()
    }

    private fun initNavigation() {
        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Выезжающее меню", Toast.LENGTH_SHORT).show()
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Смотреть позже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Колекции", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.main_recycler)

        filmsAdapter =
            FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {
                    val bundle = Bundle()
                    bundle.putParcelable("film", film)
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            })

        recyclerView.adapter = filmsAdapter

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        val decorator = TopSpacingItemDecoration(8)
        recyclerView.addItemDecoration(decorator)

        filmsAdapter.addItems(filmsDataBase)
    }
}