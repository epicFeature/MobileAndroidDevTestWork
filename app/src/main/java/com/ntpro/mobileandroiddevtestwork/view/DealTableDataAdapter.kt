package com.ntpro.mobileandroiddevtestwork.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.ntpro.mobileandroiddevtestwork.R
import com.ntpro.mobileandroiddevtestwork.domain.Server
import com.ntpro.mobileandroiddevtestwork.sorttablefork.TableDataAdapter
import java.math.RoundingMode

class DealTableDataAdapter(
    context: Context,
    dealList: List<Server.Deal>
) : TableDataAdapter<Server.Deal>(context, dealList) {
    override fun getCellView(rowIndex: Int, columnIndex: Int, parentView: ViewGroup?): View {
        val deal = getRowData(rowIndex)
        return when (columnIndex) {
            SortableDealTableView.COLUMN_DATE -> renderDate(deal)
            SortableDealTableView.COLUMN_INSTRUMENT -> renderInstrumentName(deal)
            SortableDealTableView.COLUMN_PRICE -> renderPrice(deal)
            SortableDealTableView.COLUMN_AMOUNT -> renderAmount(deal)
            else -> renderSide(deal)
        }
    }

    private fun renderDate(deal: Server.Deal) = renderString(deal.timeStamp.toString())

    private fun renderInstrumentName(deal: Server.Deal) = renderString(deal.instrumentName)

    private fun renderPrice(deal: Server.Deal): View {
        val price = deal.price.toBigDecimal().setScale(2, RoundingMode.HALF_DOWN)
        val textView = renderString(String.format(price.toString()))
        if (deal.side == Server.Deal.Side.SELL) {
            textView.setTextColor(resources.getColor(R.color.pink_bright))
        } else {
            textView.setTextColor(resources.getColor(R.color.green_bright))
        }
        return textView
    }

    private fun renderAmount(deal: Server.Deal) =
        deal.amount.toBigDecimal()
            .setScale(0, RoundingMode.HALF_DOWN)
            .let { renderString(String.format(it.toString())) }

    private fun renderSide(deal: Server.Deal) = renderString(deal.side.name)

    private fun renderString(text: String) = CellTextView(context).apply { this.text = text }
}