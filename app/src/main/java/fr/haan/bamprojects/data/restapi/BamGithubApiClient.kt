package fr.haan.bamprojects.data.restapi

import android.util.Log
import fr.haan.bamprojects.data.model.Project
import fr.haan.bamprojects.data.model.State
import fr.haan.bamprojects.data.restapi.model.ApiProjectsItem
import java.io.IOException

class BamGithubApiClient(val api: BamGithubApi) {

    companion object {
        private const val TAG = "bamprojects.api"
    }

    suspend fun getProjects(): State<List<Project>> {


        try {
            val response = api.getProjects()
            if(response.isSuccessful){
                val body = response.body()
                if(body == null){
                    return State.Error("Error parsing json data from server")
                }
                return State.Success(body.map { it.toProject() }.filterNotNull())
            }else {
                return State.Error(
                    response.message()
                )
            }
        }catch (e: IOException){
            val message  = "An error has occured." +
            " Please verify your internet connection and retry: " + e.message ?: "Unknwown error"
            return State.Error(message)
        }

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


