package com.example.socialview.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.socialview.R
import com.example.socialview.views.FontTextView
import com.hendraanggrian.appcompat.socialview.widget.SocialArrayAdapter

data class Person(val name: String, val id: Int, val avatar: String) {


    override fun toString(): String {

        return name
    }
}

class PersonAdapter(context: Context) :
    SocialArrayAdapter<Person>(context, R.layout.mention, R.id.textViewName) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: ViewHolder
        var view = convertView
        when (view) {
            null -> {
                view = LayoutInflater.from(context).inflate(R.layout.mention, parent, false)
                holder = ViewHolder(view!!)
                view.tag = holder
            }
            else -> holder = view.tag as ViewHolder
        }
        getItem(position)?.let { model ->
            holder.textView.text = model.name
            holder.personInitials.visibility = View.GONE
            holder.personInitialsBack.visibility = View.GONE
            holder.mention_avatar.visibility = View.VISIBLE
            holder.loadingView.visibility= View.GONE
        }
        return view
    }


    private class ViewHolder(view: View) {
        val textView: TextView = view.findViewById(R.id.textViewName)
        val mention_avatar: ImageView = view.findViewById(R.id.mention_avatar)
        val loadingView: ProgressBar = view.findViewById(R.id.progressBar2)
        val personInitials: FontTextView = view.findViewById(R.id.userInitialsMention)
        val personInitialsBack: ImageView = view.findViewById(R.id.userIconMention)
    }
}