package fr.haan.bamprojects.data.db

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.haan.bamprojects.data.model.Project
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ProjectDaoTest {
    private lateinit var projectDao: ProjectDao
    private lateinit var db: ProjectRoomDatabase

    @Rule
    @JvmField public val rule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ProjectRoomDatabase::class.java
        ).build()
        projectDao = db.wordDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    companion object {
        val TEST_PROJECTS = listOf(
            Project(
                id = 1,
                name = "Project1",
                description = "This is Project1"
            ),
            Project(
                id = 2,
                name = "Project2",
                description = "This is Project2"
            ),
            Project(
                id = 3,
                name = "Project3",
                description = "This is Project3"
            )
        )
    }

    @Test
    @Throws(Exception::class)
    fun can_insert_projects() {

        runBlocking {
            projectDao.insertAllProjects(TEST_PROJECTS)
        }

        assertEquals(3, projectDao.getProjects().getOrAwaitValue().size)
    }

    @Test
    @Throws(Exception::class)
    fun can_update_project() {

        runBlocking {
            projectDao.insertAllProjects(TEST_PROJECTS)
        }

        val projects = projectDao.getProjects().getOrAwaitValue()

        val updatedProject = projects
            .first { it.id == 1.toLong() }
            .copy(isFavorite = true)

        projectDao.updateProject(updatedProject)

        //Update project in DB
        val updatedProjects = projectDao.getProjects().getOrAwaitValue()

        //retrieve list of project and find the one with corresponding ID
        assertTrue(
            updatedProjects
                .first { it.id == 1.toLong() }
                .isFavorite
        )
    }

}
