package fr.haan.bamprojects.data.restapi

import fr.haan.bamprojects.data.model.Project
import fr.haan.bamprojects.data.restapi.model.ApiProjectsItem

class BamGithubApiClient(val api: BamGithubApi) {

    suspend fun getProjects(): List<Project> {
        return api.getProjects().map { it.toProject() }
    }
}

private fun ApiProjectsItem.toProject() : Project {
    return Project(name = this.name ?: "",description = this.description ?: "")
}
