package com.patrickchow.sprintchallenge1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patrickchow.sprintchallenge1.R
import com.patrickchow.sprintchallenge1.model.Movie
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        title = "Edit Movie"

        btn_save_movie.setOnClickListener{
            var intentSaveMovie = Intent()

        }

        fun createMovie(): Movie{
            var newMovie = Movie(edit_text_add_movie.text.toString(), false)
            return newMovie
        }
    }
}
