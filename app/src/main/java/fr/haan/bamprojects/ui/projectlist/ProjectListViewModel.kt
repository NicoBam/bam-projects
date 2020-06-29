package fr.haan.bamprojects.ui.projectlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.haan.bamprojects.data.model.Project
import fr.haan.bamprojects.data.projectRepository
import fr.haan.bamprojects.data.restapi.bamGithubApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProjectListViewModel : ViewModel() {


    private val _projects: MutableLiveData<List<Project>> = MutableLiveData()

    val projects: LiveData<List<Project>>

    //TODO: Use DI Framework to build and inject this
    val repository = projectRepository

    init {
        projects = repository.projects()

        viewModelScope.launch(Dispatchers.IO) {
            repository.refreshProjects()
        }
    }

    fun onFavoriteClicked(project: Project) {
        val toggledFavoriteValue = !project.isFavorite

        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProject(project.copy(
                isFavorite = toggledFavoriteValue
            ))
        }
    }

}