package fr.haan.bamprojects.data.restapi

import android.util.Log
import fr.haan.bamprojects.data.model.Project
import fr.haan.bamprojects.data.restapi.model.ApiProjectsItem

class BamGithubApiClient(val api: BamGithubApi) {

    companion object {
        private const val TAG = "bamprojects.api"
    }

    suspend fun getProjects(): List<Project> {
        return api.getProjects().map { it.toProject() }.filterNotNull()
    }

    private fun ApiProjectsItem.toProject() : Project? {
        val id = this.id
        if(id == null) {
            // Null id is a backend error, we ignore the value
            Log.w(TAG, "Null id for project item found, ignoring item!")
            return null
        }

        return Project(
            id = id.toLong(),
            name = this.name ?: "",
            description = this.description ?: "")
    }
}


