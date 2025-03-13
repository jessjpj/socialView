package com.example.socialview.views.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PeopleItem(
    @SerializedName("id") val id: Int,
    @SerializedName("status") val status: Int?,
    @SerializedName("fullName") val fullName: String?,
    @SerializedName("fullNameArabic") val fullNameArabic: String?,
    @SerializedName("avatarThumb") val avatarThumb: String?,
    @SerializedName("employment") val employment: PeopleEmployment?,
    @SerializedName("contact") val contact: PeopleContact?,
    @SerializedName("offBoarded") val offBoarded: Boolean?,
    @SerializedName("job") val job: Job?,


    ) : Serializable

