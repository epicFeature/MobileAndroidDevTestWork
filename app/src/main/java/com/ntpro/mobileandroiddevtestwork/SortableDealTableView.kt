package com.ntpro.mobileandroiddevtestwork

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.StyleRes
import de.codecrafters.tableview.SortableTableView
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter

class SortableDealTableView(context: Context) : SortableTableView<Server.Deal>(context, null) {
    fun sortableDealTableViewCreation(
        context: Context,
        attributeSet: AttributeSet,
        @StyleRes styleAttribute: Int
    ) {
        val simpleTableHeaderAdapter: SimpleTableHeaderAdapter =
            SimpleTableHeaderAdapter(
                context,
                R.string.time_header_name,
                R.string.instrument_header_name,
                R.string.price_header_name,
                R.string.amount_header_name,
                R.string.side_header_name
            )
        simpleTableHeaderAdapter
            .setTextColor(R.color.lilac_bright)
            .also { setBackgroundResource(R.color.blue_dark_block) }
        headerAdapter = simpleTableHeaderAdapter
    }
}