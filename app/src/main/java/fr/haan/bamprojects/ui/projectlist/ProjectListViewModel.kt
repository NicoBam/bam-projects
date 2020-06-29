package fr.haan.bamprojects.ui.projectlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.haan.bamprojects.data.model.Project
import fr.haan.bamprojects.data.restapi.client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProjectListViewModel : ViewModel() {

    val _projects: MutableLiveData<List<Project>> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val projects = client.getProjects()
            _projects.postValue(projects)
        }
    }

}