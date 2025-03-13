package com.example.socialview.views.models

import com.google.gson.annotations.SerializedName

data class PeopleJobTitle(
    @SerializedName("name") val name: String?,
    @SerializedName("nameArabic") val nameArabic: String?
)