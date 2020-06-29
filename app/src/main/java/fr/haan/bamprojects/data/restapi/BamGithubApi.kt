package fr.haan.bamprojects.data.restapi

import fr.haan.bamprojects.data.restapi.model.ApiProjects
import retrofit2.Response
import retrofit2.http.GET

interface BamGithubApi {
    @GET("/orgs/bamlab/repos?page=1")
    suspend fun getProjects(): Response<ApiProjects>
}