package fr.haan.bamprojects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.haan.bamprojects.data.db.buildRoomDatabase
import fr.haan.bamprojects.ui.ErrorDisplayer
import fr.haan.bamprojects.ui.errorDisplayer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        buildRoomDatabase(applicationContext)

        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        errorDisplayer = ErrorDisplayer(this)
    }

    override fun onStop() {
        super.onStop()
        errorDisplayer = null
    }
}

