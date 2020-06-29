package fr.haan.bamprojects.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project_table")
data class Project(
    @PrimaryKey
    val id: Long,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val description: String,
    @ColumnInfo
    val isFavorite: Boolean = false
)