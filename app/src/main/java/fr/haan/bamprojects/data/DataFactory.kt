package fr.haan.bamprojects.data

import fr.haan.bamprojects.data.db.projectDao
import fr.haan.bamprojects.data.restapi.bamGithubApiClient

val projectRepository by lazy {
    ProjectRepository(
        api = bamGithubApiClient,
        db = projectDao
    )
}