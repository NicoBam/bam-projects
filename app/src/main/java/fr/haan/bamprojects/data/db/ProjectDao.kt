package fr.haan.bamprojects.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.haan.bamprojects.data.model.Project

@Dao
interface ProjectDao {

    @Query("SELECT * from project_table")
    fun getProjects(): LiveData<List<Project>>

    //FIXME: Ignore Strategy keeps favorites in DB but prevent updating other fields from network
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllProjects(projects: List<Project>)

    @Update
    suspend fun updateProject(project: Project)
}