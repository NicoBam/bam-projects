package fr.haan.bamprojects.data.restapi.model


import com.google.gson.annotations.SerializedName

data class Permissions(
    @SerializedName("admin")
    val admin: Boolean?,
    @SerializedName("push")
    val push: Boolean?,
    @SerializedName("pull")
    val pull: Boolean?
)