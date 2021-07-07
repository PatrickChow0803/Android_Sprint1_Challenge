package com.patrickchow.sprintchallenge1.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patrickchow.sprintchallenge1.R
import com.patrickchow.sprintchallenge1.model.Movie
import kotlinx.android.synthetic.main.activity_edit.*

//EditActivity is used to add and edit movies

class EditActivity : AppCompatActivity() {

    var watchFlag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        title = "Edit Movie"


        //Pressing the button gives ListActivity the data about the movie and returns to ListActivity
        //The "movie" in putExtra is used as a key to get the information from ListActivity
        btn_save_movie.setOnClickListener{
            var intentSaveMovie = Intent()
            intentSaveMovie.putExtra("movie", createMovie())
            setResult(RESULT_OK, intentSaveMovie)
            finish()
        }

        //Deletes the view by pressing back if the delete button is pressed
        btn_delete_movie.setOnClickListener{
            onBackPressed()
        }

        //Toggle for if the movie is watched or not
        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                watchFlag = false
            }
            else{
                watchFlag = true
            }
        }

        //createTextView's listener will refer to this
        //Call editMovie using information from the view's listener intent
        var bundle: Bundle?= intent.extras
            if(bundle!=null) {
                editMovie(bundle.getSerializable("movieKey") as Movie)
            }
    }
    //Create and return a Movie object by using text from EditText and with a boolean value
    fun createMovie(): Movie{

        var newMovie = Movie(edit_text_add_movie.text.toString(), watchFlag)
        return newMovie
    }

    //Used for when the user taps on a view to edit the title of the movie
    fun editMovie(movie: Movie){
        val title = movie.title
        edit_text_add_movie.setText(title)
    }
}
