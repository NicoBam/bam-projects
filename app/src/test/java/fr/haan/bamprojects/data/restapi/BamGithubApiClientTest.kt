package fr.haan.bamprojects.data.restapi

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class BamGithubApiClientTest {


    @Test
    fun api_client_returns_some_projets() {
        runBlocking {
            val projects = client.getProjects()
            projects.forEach {
                println(it)
            }
            Assert.assertTrue(projects.size > 0)
        }
    }
}