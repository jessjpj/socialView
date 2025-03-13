package com.example.socialview.views.models

import com.google.gson.annotations.SerializedName

data class PeopleContact(
    @SerializedName("email") val email: String?,
    @SerializedName("mobileNumber") val mobileNumber: String?
)