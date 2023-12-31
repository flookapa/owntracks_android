package org.owntracks.android.ui.preferences

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder

class FilePickerPreference : Preference {

    lateinit var view: View

    @Suppress("unused")
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    @Suppress("unused")
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @Suppress("unused")
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    @Suppress("unused")
    constructor(context: Context) : super(context)

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        view = holder.itemView
        super.onBindViewHolder(holder)
    }
}
