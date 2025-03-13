package com.example.socialview.utils

import android.app.Application
import android.app.ProgressDialog
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.socialview.views.adapters.PersonAdapter
import com.example.socialview.views.models.PeopleItem


import android.content.Context
import android.util.Log
import com.example.socialview.views.adapters.Person
import java.io.IOException
import java.io.InputStream

object Mention {
    lateinit var customMentionAdapter: ArrayAdapter<Person>
    private var peopleList: List<PeopleItem> = listOf()

    private fun loadPeopleFromJson(context: Context) {
        val jsonString = getJsonFromAssets(context, "people.json")
        if (jsonString != null) {
            val type = object : TypeToken<List<PeopleItem>>() {}.type
            try {
                peopleList = Gson().fromJson(jsonString, type)
            } catch (e: Exception) {
                Log.e("Mention", "Error parsing JSON: ${e.message}")
            }
        }
    }

    private fun getJsonFromAssets(context: Context, fileName: String): String? {
        return try {
            val inputStream: InputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            Log.e("Mention", "Error reading JSON file: ${e.message}")
            null
        }
    }

    fun createMention(context: Context, adapter: PersonAdapter) {
        loadPeopleFromJson(context)
        adapter.clear()
        for (person in peopleList) {
            adapter.add(
                Person(
                    person.fullName ?: "Unknown",
                    person.id,
                    person.avatarThumb ?: ""
                )
            )
        }
    }
}