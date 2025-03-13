package com.example.socialview.views.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PeopleEmployment(
    @SerializedName("jobTitle") val jobTitle: PeopleJobTitle?,
    @SerializedName("location") val location: Location?,
    @SerializedName("team") val team: GeneralItemObject?
):Serializable

data class Location(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("nameArabic") val nameArabic: String?
):Serializable

