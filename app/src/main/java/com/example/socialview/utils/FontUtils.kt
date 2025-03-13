package com.example.socialview.utils

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import java.util.HashMap
import com.example.socialview.R

object FontUtils {
    private val DEFAULT_STYLE: FontStyle = FontStyle.REGULAR

    private val fontMap: MutableMap<String, Typeface> = HashMap()


    private fun getFont(context: Context, fontName: String?): Typeface? {
        return if (fontMap.containsKey(
                fontName
            )
        ) {
            fontMap[fontName]
        } else {
            try {
                val tf = Typeface.createFromAsset(context.applicationContext.assets, fontName)
                fontName?.let { fontMap.put(it, tf) }
                tf
            } catch (e: java.lang.Exception) {
                Log.d("", "getFont: ", e)
                null
            }
        }
    }

    private fun getFontPath(context: Context, style: FontStyle): String? {
        return when (style) {
            FontStyle.BOLD -> context.getString(R.string.custom_font_path_bold)
            FontStyle.REGULAR -> context.getString(R.string.custom_font_path_regular)
            FontStyle.DISPLAY -> context.getString(R.string.custom_font_path_display)
            FontStyle.DBOLD -> context.getString(R.string.custom_font_path_display_bold)
            FontStyle.SEMIBOLD -> context.getString(R.string.custom_font_path_display_bold)
        }
    }

    fun setCustomFont(textview: TextView, attrs: AttributeSet?) {
        val style: FontStyle
        if (attrs != null) {
            val a = textview.context.theme
                .obtainStyledAttributes(attrs, R.styleable.FontTextView, 0, 0)
            style = FontStyle.createFromId(a.getInt(R.styleable.FontTextView_style, 0))
            a.recycle()
        } else {
            style = DEFAULT_STYLE

        }
        setCustomFont(textview, style)
    }

    private fun setCustomFont(textview: TextView, style: FontStyle?) {
        val path = style?.let { getFontPath(textview.context, it) }
        if (!TextUtils.isEmpty(path)) {
            val typeface: Typeface? = getFont(textview.context, path)
            if (typeface != null) {
                textview.typeface = typeface
            }
        }
    }

}

enum class FontStyle(private val id: Int) {
    REGULAR(0), BOLD(1), DISPLAY(2), DBOLD(3), SEMIBOLD(4);

    companion object {
        fun createFromId(id: Int): FontStyle {
            for (style in values()) {
                if (style.id == id) return style
            }
            throw IllegalArgumentException()
        }
    }

}