package fr.haan.bamprojects.data

import androidx.lifecycle.LiveData
import fr.haan.bamprojects.data.db.ProjectDao
import fr.haan.bamprojects.data.model.Project
import fr.haan.bamprojects.data.restapi.BamGithubApiClient

class ProjectRepository(val api: BamGithubApiClient, val db: ProjectDao) {

    suspend fun refreshProjects() {
        val projects = api.getProjects()
        db.insertAllProjects(projects)
    }

    fun projects(): LiveData<List<Project>> {
        return db.getProjects()
    }

    suspend fun updateProject(updatedProject: Project) {
        db.updateProject(updatedProject)
    }

}