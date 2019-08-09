package com.patrickchow.sprintchallenge1.ui

import android.app.Activity
import android.content.Intent
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE_EDIT_MOVIE && resultCode == Activity.RESULT_OK){
            val newMovieResult = data!!.getSerializableExtra("movie") as Movie
            movieList.add(newMovieResult)
            var text = TextView(this)
            text.text = newMovieResult.title
            linear_layout.addView(text)
        }
    }
}
