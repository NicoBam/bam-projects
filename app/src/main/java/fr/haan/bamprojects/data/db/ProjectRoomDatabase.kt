package fr.haan.bamprojects.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.haan.bamprojects.data.model.Project

@Database(entities = arrayOf(Project::class), version = 1, exportSchema = true)
abstract class ProjectRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): ProjectDao

}
