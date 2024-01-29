package com.ntpro.mobileandroiddevtestwork

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.StyleRes
import androidx.core.content.ContextCompat
import de.codecrafters.tableview.SortableTableView
import de.codecrafters.tableview.model.TableColumnWeightModel
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter
import de.codecrafters.tableview.toolkit.SortStateViewProviders
import de.codecrafters.tableview.toolkit.TableDataRowBackgroundProviders

class SortableDealTableView(context: Context) : SortableTableView<Server.Deal>(context) {

    fun createSortableDealTableView(
        context: Context,
        attributes: AttributeSet//,
        //@StyleRes styleAttributes: Int
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
            .setTextColor(R.color.table_header_text)
        //.also { setBackgroundResource(R.color.blue_dark_block) }
        headerAdapter = simpleTableHeaderAdapter

        val rowColorEven = ContextCompat.getColor(context, R.color.table_data_row_even)
        val rowColorOdd = ContextCompat.getColor(context, R.color.table_data_row_odd)
        setDataRowBackgroundProvider(
            TableDataRowBackgroundProviders.alternatingRowColors(
                rowColorEven,
                rowColorOdd
            )
        )

        headerSortStateViewProvider = SortStateViewProviders.brightArrows()

        val tableColumnWeightModel = TableColumnWeightModel(5)
        tableColumnWeightModel.setColumnWeight(0, 2)
        tableColumnWeightModel.setColumnWeight(1, 3)
        tableColumnWeightModel.setColumnWeight(2, 3)
        tableColumnWeightModel.setColumnWeight(3, 2)
        tableColumnWeightModel.setColumnWeight(4, 2)
        columnModel = tableColumnWeightModel

        val dealComparators = DealComparators()
        setColumnComparator(0, dealComparators.getDealDateComparator())
        setColumnComparator(1, dealComparators.getDealInstrumentComparator())
        setColumnComparator(2, dealComparators.getDealPriceComparator())
        setColumnComparator(3, dealComparators.getDealAmountComparator())
        setColumnComparator(3, dealComparators.getDealSideComparator())

    }
}
