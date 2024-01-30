package com.ntpro.mobileandroiddevtestwork.domain

class DealComparators {

    fun getDealDateComparator(): Comparator<Server.Deal> = DealDateComparator()

    fun getDealInstrumentComparator(): Comparator<Server.Deal> = DealInstrumentComparator()

    fun getDealPriceComparator(): Comparator<Server.Deal> = DealPriceComparator()

    fun getDealAmountComparator(): Comparator<Server.Deal> = DealAmountComparator()

    fun getDealSideComparator(): Comparator<Server.Deal> = DealSideComparator()

    private class DealDateComparator : Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?) =
            deal1?.timeStamp?.compareTo(deal2?.timeStamp) ?: 0
    }

    private class DealInstrumentComparator : Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?) =
            deal2?.instrumentName?.let { deal1?.instrumentName?.compareTo(it) } ?: 0
    }

    private class DealPriceComparator : Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?) =
            deal2?.price?.let { deal1?.price?.compareTo(it) } ?: 0
    }

    private class DealAmountComparator : Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?) =
            deal2?.amount?.let { deal1?.amount?.compareTo(it) } ?: 0
    }

    private class DealSideComparator : Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?) =
            deal2?.side?.let { deal1?.side?.compareTo(it) } ?: 0
    }
}