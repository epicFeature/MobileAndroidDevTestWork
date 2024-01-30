package com.ntpro.mobileandroiddevtestwork

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import de.codecrafters.tableview.TableDataAdapter
import java.math.RoundingMode

class DealTableDataAdapter(
    context: Context,
    dealList: List<Server.Deal>
) : TableDataAdapter<Server.Deal>(context, dealList) {
    override fun getCellView(rowIndex: Int, columnIndex: Int, parentView: ViewGroup?): View {
        val deal = getRowData(rowIndex)
        return when (columnIndex) {
            0 -> renderDate(deal) //TODO перенести цифры в константы
            1 -> renderInstrumentName(deal)
            2 -> renderPrice(deal)
            3 -> renderAmount(deal)
            else -> renderSide(deal)
        }
    }

    private fun renderDate(deal: Server.Deal): View { //временно, проверить формат
        return renderString(deal.timeStamp.toString())
    }

    private fun renderInstrumentName(deal: Server.Deal): View { //временно, проверить формат
        return renderString(deal.instrumentName)
    }

    private fun renderPrice(deal: Server.Deal): View {
        val price = deal.price.toBigDecimal().setScale(2, RoundingMode.HALF_DOWN)
        val textView = TextView(context)
        if (deal.side == Server.Deal.Side.SELL) {
            textView.setTextColor(resources.getColor(R.color.pink_bright))
        } else {
            textView.setTextColor(resources.getColor(R.color.green_bright))
        }

        textView.setPadding(20, 10, 20, 10)
        textView.textSize = 14F //TODO в константы
        textView.text = String.format(price.toString())
        textView.gravity = Gravity.CENTER
        return textView
    }

    private fun renderAmount(deal: Server.Deal): View {
        val amount = deal.amount.toBigDecimal().setScale(0, RoundingMode.HALF_DOWN) //Formatter util class (object)
        val textView = CellTextView(context)
       textView.text = String.format(amount.toString())
        return textView
    }

    private fun renderSide(deal: Server.Deal): View { //временно, проверить формат
        return renderString(deal.side.name)
    }

    private fun renderString (text: String): TextView {
        val textView = TextView(context)
        textView.text = text
        textView.gravity = Gravity.CENTER
        textView.setPadding(20, 10, 20, 10)
        textView.textSize = 14F
        return textView
    }
}