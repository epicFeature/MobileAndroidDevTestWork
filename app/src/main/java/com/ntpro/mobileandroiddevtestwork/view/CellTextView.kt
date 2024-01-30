package com.ntpro.mobileandroiddevtestwork.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity

class CellTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyle) {

    init {
        setPadding(20, 10, 20, 10)
        gravity = Gravity.CENTER
        textSize = FONT_SIZE
    }

    companion object {
        const val FONT_SIZE = 14F
    }
}