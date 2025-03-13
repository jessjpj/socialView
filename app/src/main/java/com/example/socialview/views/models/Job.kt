package com.example.socialview.views.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Job(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("nameArabic") var nameArabic: String? = null

):Serializable