package fr.haan.bamprojects.data

import fr.haan.bamprojects.data.db.ProjectDao
import fr.haan.bamprojects.data.restapi.BamGithubApiClient
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Ignore
import org.junit.Test

class ProjectRepositoryTest {


    val mockApi =mockk<BamGithubApiClient> {}
    val db =mockk<ProjectDao> {}
    val projectRepository = ProjectRepository(
        mockApi, db
    )

    @Ignore("Unfinished test")
    @Test
    fun refresh_projects_Call_network_client() {
        runBlocking {
            projectRepository.refreshProjects()
        }

        //verify { mockApi.getProjects() }
    }
}