package fr.haan.bamprojects.data.db

import android.content.Context
import androidx.room.Room


lateinit var roomDatabase : ProjectRoomDatabase

/**
 * Factory method for Room database, must be called on Application Startup
 * TODO: Use a Depency Injection Framework to get rid of this
 */
fun buildRoomDatabase(context: Context) {

//    roomDatabase = Room.inMemoryDatabaseBuilder(
//        context.applicationContext, ProjectRoomDatabase::class.java).build()


    roomDatabase = Room.databaseBuilder(
        context.applicationContext,
        ProjectRoomDatabase::class.java,
        "project_database"
    )
        .build()
}

val projectDao: ProjectDao by lazy {
    roomDatabase.wordDao()
}