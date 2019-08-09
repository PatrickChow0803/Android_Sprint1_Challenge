package com.patrickchow.sprintchallenge1.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.patrickchow.sprintchallenge1.R
import com.patrickchow.sprintchallenge1.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity() {

    var movieList = mutableListOf<Movie>()
    var counter = 0

    companion object{
        const val REQUEST_CODE_EDIT_MOVIE = 10
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "List of Movies"

        btn_add_movie.setOnClickListener{
            var intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_EDIT_MOVIE)
        }
    }

    //Return a TextView by using the information about a movie
    fun createTextView(movie: Movie, index: Int) :TextView{
        var newMovieView = TextView(this)
        newMovieView.id = index
        newMovieView.text = movie.title

        //ToDo
        //Temporary, if movie is watched, then make the text red.
        //The code should however make the text strike-though
        if(movie.watched==true)
            newMovieView.setTextColor(Color.RED)
        return newMovieView
    }

    //Get the result from EditActivity, place the new movie in the list,
    //Call createTextView and then place that new TextView into the Linear Layout
    //The "movie" is used as a key to communicate with EditActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE_EDIT_MOVIE && resultCode == Activity.RESULT_OK){
            val newMovieResult = data!!.getSerializableExtra("movie") as Movie
            movieList.add(newMovieResult)
            val newMovieView = createTextView(newMovieResult, counter)
            linear_layout.addView(newMovieView)
            counter++
        }
    }
}
