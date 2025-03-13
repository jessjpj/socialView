package com.example.socialview.views.models

import java.io.Serializable
import java.util.*
import com.google.gson.annotations.SerializedName

data class PeopleDisplayItem(
    val id: Int,
    val name: String,
    val jobDescription: String?,
    val iconAvatarPath: String?,
    val iconDescriptionDrawable: Int,
    val phoneNumber: String?,
    val email: String?,
    val jobDepartment: String?,
    val location: String?,
    val date: String?,
    val reason: String?,
    val startDate: String?,
    val endDate: String?,
    val associatedEvent: String? = "",
    val team:GeneralItemObject? = null
)

data class GeneralItemObject(
    @SerializedName("id") val id: Int,
    @SerializedName(value = "name", alternate = ["title"]) var name: String?,
    @SerializedName(value = "nameArabic", alternate = ["titleArabic"]) val nameArabic: String? = "",
    @SerializedName("isDefault") val isDefault: Boolean = false,
    @SerializedName("isDeletable") val isDeletable: Boolean = false,
    @SerializedName("value") val value: String = "",
    @SerializedName("icon") val icon: Int? = null,
    @Transient val color: Int? = null,
    @Transient var isSelected: Boolean? = false,


    //spinner fields
    val text: String? = null,
    val text1: String? = null,
    var text2: String? = null
) : Serializable