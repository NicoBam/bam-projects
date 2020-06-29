package fr.haan.bamprojects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.haan.bamprojects.data.db.buildRoomDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        buildRoomDatabase(applicationContext)

        setContentView(R.layout.activity_main)
    }
}