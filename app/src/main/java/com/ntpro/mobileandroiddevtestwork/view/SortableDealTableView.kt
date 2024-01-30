package com.ntpro.mobileandroiddevtestwork.view

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.ntpro.mobileandroiddevtestwork.R
import com.ntpro.mobileandroiddevtestwork.domain.Server
import com.ntpro.mobileandroiddevtestwork.domain.DealComparators
import de.codecrafters.tableview.SortableTableView
import de.codecrafters.tableview.model.TableColumnWeightModel
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter
import de.codecrafters.tableview.toolkit.SortStateViewProviders
import de.codecrafters.tableview.toolkit.TableDataRowBackgroundProviders

class SortableDealTableView(context: Context, attributeSet: AttributeSet?) :
    SortableTableView<Server.Deal>(context, attributeSet) {

    init {
        SimpleTableHeaderAdapter(
            context,
            R.string.time_header_name,
            R.string.instrument_header_name,
            R.string.price_header_name,
            R.string.amount_header_name,
            R.string.side_header_name
        ).apply {
            setTextSize(HEADER_TEXT_SIZE)
        }.let { headerAdapter = it }

        this.setHeaderBackground(R.color.table_header_background)

        setDataRowBackgroundProvider(
            TableDataRowBackgroundProviders.alternatingRowColors(
                ContextCompat.getColor(context, R.color.table_data_row_even),
                ContextCompat.getColor(context, R.color.table_data_row_odd)
            )
        )

        headerSortStateViewProvider = SortStateViewProviders.brightArrows()

        val tableColumnWeightModel = TableColumnWeightModel(5)
        val dealComparators = DealComparators()
        for (i in 0..tableColumnWeightModel.columnCount) {
            var comparator: Comparator<Server.Deal>
            when (i) {
                COLUMN_DATE -> {
                    comparator = dealComparators.getDealDateComparator()
                    setColumnComparator(COLUMN_DATE, comparator)
                }

                COLUMN_INSTRUMENT -> {
                    comparator = dealComparators.getDealInstrumentComparator()
                    setColumnComparator(COLUMN_INSTRUMENT, comparator)
                }

                COLUMN_PRICE -> {
                    comparator = dealComparators.getDealPriceComparator()
                    setColumnComparator(COLUMN_PRICE, comparator)
                }

                COLUMN_AMOUNT -> {
                    comparator = dealComparators.getDealAmountComparator()
                    setColumnComparator(COLUMN_AMOUNT, comparator)
                }

                COLUMN_SIDE -> {
                    comparator = dealComparators.getDealSideComparator()
                    setColumnComparator(COLUMN_SIDE, comparator)
                }
            }
        }
        columnModel = tableColumnWeightModel
    }

    companion object {
        const val COLUMN_DATE = 0
        const val COLUMN_INSTRUMENT = 1
        const val COLUMN_PRICE = 2
        const val COLUMN_AMOUNT = 3
        const val COLUMN_SIDE = 4
        const val HEADER_TEXT_SIZE = 14

    }
}
